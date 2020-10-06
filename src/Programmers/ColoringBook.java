package Programmers;

public class ColoringBook {

	public static void main(String[] args) {
		int m = 6;
		int n = 4;
		int[][] picture = { { 1, 1, 1, 0 }, { 1, 2, 2, 0 }, { 1, 0, 0, 1 }, { 0, 0, 0, 1 }, { 0, 0, 0, 3 },
				{ 0, 0, 0, 3 } };

		ColoringBook cb = new ColoringBook();

		int[] ret = cb.solution(m, n, picture);

		System.out.println(ret[0]);
		System.out.println(ret[1]);
	}

	public int[] solution(int m, int n, int[][] picture) {
		int numberOfArea = 0;
		int maxSizeOfOneArea = 0;

		Graph g = new Graph(m, n, picture);

		g.find();

		int[] answer = new int[2];
		answer[0] = g.areas;
		answer[1] = g.maxSize;
		return answer;
	}

	public class Graph {
		int[][] picture;
		int[][] visited;
		int m;
		int n;
		int areas;
		int maxSize;

		public Graph(int m, int n, int[][] picture) {
			this.m = m;
			this.n = n;
			this.picture = picture;
			this.visited = new int[this.m][this.n];

			// visited init
			for (int i = 0; i < this.m; i++) {
				for (int j = 0; j < this.n; j++) {
					this.visited[i][j] = 0;
				}
			}

			this.areas = 0;
			this.maxSize = 0;
		}

		public void find() {
			for (int i = 0; i < m; i++) {
				for (int j = 0; j < n; j++) {
					if (visited[i][j] == 0 && picture[i][j] != 0) {
						int s = dfs(i, j);
						areas++;
						if (maxSize < s) {
							maxSize = s;
						}
					}
				}
			}
		}

		public int dfs(int i, int j) {
			int sum = 1;
			visited[i][j] = 1;
			System.out.println("i = " + i + ", j = " + j);
			if (i - 1 >= 0 && picture[i - 1][j] == picture[i][j] && visited[i - 1][j] == 0) {
				sum += dfs(i - 1, j);
			}
			if (j - 1 >= 0 && picture[i][j - 1] == picture[i][j] && visited[i][j - 1] == 0) {
				sum += dfs(i, j - 1);
			}
			if (i + 1 < m && picture[i + 1][j] == picture[i][j] && visited[i + 1][j] == 0) {
				sum += dfs(i + 1, j);
			}
			if (j + 1 < n && picture[i][j + 1] == picture[i][j] && visited[i][j + 1] == 0) {
				sum += dfs(i, j + 1);
			}

			return sum;
		}
	}
}
