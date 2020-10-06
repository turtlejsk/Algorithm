package Naver2020;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class TreeNaver {

	public static void main(String[] args) {
		int n = 9;
		int[][] edges = { { 0, 2 }, { 2, 1 }, { 2, 4 }, { 3, 5 }, { 5, 4 }, { 5, 7 }, { 7, 6 }, { 6, 8 } };

		int[] result = { 2, 5 };

		TreeNaver tn = new TreeNaver();
		tn.solution(n, edges);

	}

	public int[] solution(int n, int[][] edges) {
		int[] answer = {};

		Graph g = new Graph(n, edges);
		ArrayList<Integer> arr = new ArrayList();

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < edges.length; j++) {
				g.remove(edges[j]);
				g.dfs(i);
				System.out.println(g.subset.size());
				if (g.subset.size() == (n / 3) || g.subset.size() == (n / 3) * 2) {
					arr.add(j);
					System.out.println("1");
					if (arr.size() == 2) {
						System.out.println("!!");
					}
					g.initGraph();
					g.initSubset();
					g.initVisited();
				} else {
					g.initSubset();
					g.initVisited();
					g.initGraph();
				}
			}

		}

		return answer;
	}

	class Graph {
		ArrayList<Integer>[] adjList;
		boolean[] visited;
		int[][] edges;
		int n;
		ArrayList<Integer> subset;

		public Graph(int n, int[][] edges) {
			this.n = n;
			adjList = new ArrayList[n];
			for (int i = 0; i < n; i++) {
				adjList[i] = new ArrayList<Integer>();
			}
			visited = new boolean[n];
			initVisited();
			this.edges = edges;
			this.subset = new ArrayList<>();

			initGraph();
		}

		public void initGraph() {
			for (int i = 0; i < edges.length; i++) {
				int from = edges[i][0];
				int to = edges[i][1];
				addVertex(from, to);
			}
		}

		public void initVisited() {
			for (boolean b : visited) {
				b = false;
			}
		}

		public void initSubset() {
			this.subset.clear();
		}

		public void addVertex(int from, int to) {
			adjList[from].add(to);
			adjList[to].add(from);
		}

		public void remove(int[] edge) {
			int idx = adjList[edge[0]].indexOf(edge[1]);
			adjList[edge[0]].remove(idx);

			int idx2 = adjList[edge[1]].indexOf(edge[0]);
			adjList[edge[1]].remove(idx2);

		}

		public void dfs(int start) {
			dfsUtil(start);
		}

		public void dfsUtil(int start) {
			visited[start] = true;
			subset.add(start);
			Iterator<Integer> i = this.adjList[start].listIterator();
			while (i.hasNext()) {
				int n = i.next();
				if (!visited[n]) {
					dfsUtil(n);
				}
			}
		}

	}
}
