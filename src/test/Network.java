package test;

import java.util.*;

public class Network {
	public static void main(String[] args) {
		int n = 3;
		int[][] computers = { { 1, 1, 0 }, { 1, 1, 0 }, { 0, 0, 1 } };
		// System.out.println(solution(n, computers));

		int n2 = 3;
		int[][] computers2 = { { 1, 1, 0 }, { 1, 1, 1 }, { 0, 1, 1 } };

		Graph g = new Graph(n, computers);
		int answer = 0;

		while (g.networkCheck() < g.n) {

			System.out.println("netcheck: " + g.networkCheck());
			g.dfs(g.networkCheck());
			for (int i : g.visited) {
				System.out.println(i);
			}
			answer++;
		}

		System.out.println(answer);
		// System.out.println(solution(n2, computers2));
	}

	public int solution(int n, int[][] computers) {
		int answer = 0;
		int numOfNet = 0;
		Graph g = new Graph(n, computers);
		while (g.networkCheck() >= 0) {
			int disconn = 0;
			for (int i = 0; i < n; n++) {
				if (g.getVisited()[i] != 1) {
					disconn = i;
				}
			}
			g.dfs(disconn);
			answer++;
		}
		if (g.networkCheck() == g.n - 1) {
			answer++;
		}

		return answer;
	}

}

class Graph {
	int[][] computers;
	int n;
	int[] visited;

	public Graph(int n, int[][] computers) {
		this.n = n;
		this.computers = computers;
		this.visited = new int[computers.length];
		for (int v : this.visited) {
			v = 0;
		}
	}

	public int[] getVisited() {
		return this.visited;
	}

	public void dfs(int start) {
		this.visited[start] = 1;
		for (int i = 0; i < this.computers[start].length; i++) {
			if (this.computers[start][i] == 1 && this.visited[i] == 0) {
				dfs(i);
			}
		}
	}

	public int networkCheck() {
		int index = 0;
		for (int i : this.visited) {

			if (i != 1) {
				break;
			}
			index++;
		}

		if (index != this.n) {
			System.out.println("return index : " + index);
			return index;
		} else {
			return visited.length;
		}
	}
}
