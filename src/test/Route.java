package test;

import java.util.*;

public class Route {

	Route() {

	}

	public static void main(String[] args) {
		String[][] tickets = { { "ICN", "JFK" }, { "HND", "IAD" }, { "JFK", "HND" } };
		String[][] tickets2 = { { "ICN", "SFO" }, { "ICN", "ATL" }, { "SFO", "ATL" }, { "ATL", "ICN" },
				{ "ATL", "SFO" } };
		String[][] tickets3 = { { "ICN", "A" }, { "ICN", "B" }, { "B", "ICN" } };
		Route r = new Route();
		String[] answer = r.solution(tickets3);
		for (int i = 0; i < answer.length; i++) {
			System.out.println(answer[i]);
		}

	}

	public String[] solution(String[][] tickets) {
		String[] answer = {};

		Graph g = new Graph(tickets);
		int startAirport = g.airports.indexOf("ICN");
		int flight = 0;
		String[] ret = new String[g.vs.length + 1];
		ArrayList<String> answerList = new ArrayList();
		g.dfs(startAirport, flight, answerList);
		int idx = 0;
		for (String route : answerList) {
			ret[idx] = route;
			idx++;
		}
		answer = ret;

		return answer;
	}

	class Graph {
		Vertex[] vs;
		ArrayList<String> airports;
		int[][] map;
		int[] visited;

		Graph(String[][] tickets) {
			this.vs = new Vertex[tickets.length];
			this.airports = new ArrayList<>();
			this.init(tickets);
		}

		public void init(String[][] tickets) {
			int idx = 0;
			for (String[] ticket : tickets) {
				String dep = ticket[0];
				String arr = ticket[1];
				Vertex v = new Vertex(dep, arr);
				this.vs[idx] = v;
				idx++;
				this.addAirports(v);
			}

			// airports sort
			Collections.sort(airports);

			this.map = new int[airports.size()][airports.size()];

			for (Vertex ticket : this.vs) {
				String dep = ticket.dep;
				String arr = ticket.arr;

				int depIdx = this.airports.indexOf(dep);
				int arrIdx = this.airports.indexOf(arr);

				map[depIdx][arrIdx] += 1;
			}

		}

		public void addAirports(Vertex v) {
			String dep = v.dep;
			String arr = v.arr;
			if (!this.airports.contains(dep)) {
				airports.add(dep);
			}
			if (!this.airports.contains(arr)) {
				airports.add(arr);
			}
		}

		public void dfs(int start, int flight, ArrayList<String> answerList) {

			if (flight == vs.length) {
				answerList.add(flight, airports.get(start));
				return;
			} else {
				answerList.add(flight, airports.get(start));
				for (int i = 0; i < map.length; i++) {
					if (map[start][i] >= 1) {
						map[start][i] -= 1;
						dfs(i, flight + 1, answerList);
					}
				}
			}
		}

		class Vertex {
			String dep;
			String arr;
			int used;

			Vertex(String dep, String arr) {
				this.dep = dep;
				this.arr = arr;
				this.used = 0;
			}
		}
	}
}