package Programmers;

public class GPS {

	public static void main(String[] args) {
		int n1 = 7;
		int m1 = 10;
		int[][] edge_list1 = { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 }, { 4, 6 }, { 5, 6 }, { 5, 7 },
				{ 6, 7 } };
		int k1 = 6;
		int[] gps_log1 = { 1, 2, 3, 3, 6, 7 };
		int answer1 = 1;

		int n2 = 7;
		int m2 = 10;
		int[][] edge_list2 = { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 }, { 4, 6 }, { 5, 6 }, { 5, 7 },
				{ 6, 7 } };
		int k2 = 6;
		int[] gps_log2 = { 1, 2, 4, 6, 5, 7 };
		int answer2 = 0;

		GPS gps = new GPS();
		int ret1 = gps.solution(n1, m1, edge_list1, k1, gps_log1);
		System.out.println(ret1);
		System.out.println(ret1 == answer1);

		int ret2 = gps.solution(n2, m2, edge_list2, k2, gps_log2);
		System.out.println(ret2);
		System.out.println(ret2 == answer2);
	}

	public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
		int answer = 0;

		Graph g = new Graph(n, m, edge_list, k, gps_log);

		answer = g.dfs(0);

		return answer;
	}

	public class Graph {
		int[][] map;
		int[] visited;

		int m;
		int n;
		int k;
		int[][] edge_list;
		int[] gps_log;
		int INF = 1000000;

		public Graph(int m, int n, int[][] edge_list, int k, int[] gps_log) {
			this.map = new int[m + 1][m + 1];

			for (int i = 0; i < m + 1; i++) {
				for (int j = 0; j < m + 1; j++) {
					this.map[i][j] = 0;
				}
			}

			for (int i = 0; i < n; i++) {
				this.map[edge_list[i][0]][edge_list[i][1]] = 1;
				this.map[edge_list[i][1]][edge_list[i][0]] = 1;
			}

			this.visited = new int[m + 1];
			for (int i = 0; i <= m; i++) {
				this.visited[i] = 0;
			}

			this.m = m;
			this.n = n;
			this.k = k;
			this.edge_list = edge_list;
			this.gps_log = gps_log;
		}

		public int dfs(int k) {
			int ret = INF;
			visited[gps_log[k]] = 1;

			if (k == this.k - 1) {
				return 0;
			}
			int from = gps_log[k];
			int to = gps_log[k + 1];
			System.out.println("from " + from + ", to " + to);

			if (map[gps_log[k]][gps_log[k + 1]] == 1 && visited[gps_log[k + 1]] == 0) {
				ret = Math.min(ret, dfs(k + 1));
			} else if (map[gps_log[k]][gps_log[k + 1]] == 0) {
				System.out.println("수정");
				for (int i = 1; i < m + 1; i++) {
					if (map[gps_log[k]][i] == 1 && visited[gps_log[i]] == 0) {
						int tmp = gps_log[k];
						gps_log[k+1] = i;
						ret = Math.min(ret, 1 + dfs(k + 1));
						gps_log[k] = tmp;
					}
				}
			}

			return ret;
		}
	}
}
