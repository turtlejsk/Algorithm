package Programmers;

public class GoSchool {
	public static void main(String[] args) {
		GoSchool gs = new GoSchool();

		int m = 4;
		int n = 3;
		int[][] puddles = { { 2, 2 } };

		int ret1 = gs.solution(m, n, puddles);
		System.out.println(ret1);
	}

	public int solution(int m, int n, int[][] puddles) {
		int answer = 0;

		int[][] cache = new int[n + 1][m + 1];

		for (int i = 0; i < n + 1; i++) {
			cache[i][0] = 0;
		}
		for (int i = 0; i < m + 1; i++) {
			cache[0][i] = 0;
		}

		for (int[] p : puddles) {
			cache[p[1]][p[0]] = -1;
		}

		for (int i = 1; i < n + 1; i++) {
			for (int j = 1; j < m + 1; j++) {
				if (cache[i][j] == -1) {

					cache[i][j] = 0;
				} else if (i == 1 & j == 1) {
					cache[i][j] = 1;
				} else {
					cache[i][j] = (cache[i - 1][j] + cache[i][j - 1]) % 1000000007;
				}
			}
		}

		answer = cache[n][m];

		return answer;
	}

}
