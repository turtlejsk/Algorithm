package Programmers;

import java.util.*;

public class ExpressN {

	public ExpressN() {

	}

	public static void main(String[] args) {
		int N = 4;
		int number = 17;
		ExpressN e = new ExpressN();

		int answer = e.solution(N, number);
		System.out.println(answer);

	}

	public int solution(int N, int number) {
		int answer = 0;

		int INF = 987654321;
		int[] dp = new int[32000];

		Arrays.fill(dp, INF);

		dp[N] = 1;
		dp[N + N] = 2;
		dp[N * N] = 2;
		dp[1] = 2;
		dp[0] = 2;
		dp[N * 11] = 2;
		dp[N * 111] = 3;
		dp[N * 1111] = 4;
		if (N < 3) {
			dp[N * 11111] = 5;
		}
		if (N == 1) {
			dp[1] = 1;
		}
		int[] series = { 1, 11, 111, 1111, 11111 };

		for (int i = 0; i < number + 1; i++) {

			if (dp[i] == INF) {
				int min = INF;
				for (int j = 0; j < ((number < 3) ? series.length : (series.length - 1)); j++) {
					int plus = dp[i + N * series[j]];
					min = Math.min(min, plus);
					int minus = INF;
					if (i >= N * series[j]) {
						minus = dp[i - N * series[j]];
						min = Math.min(min, minus);
					}
					int mul = dp[i * N * series[j]];
					min = Math.min(min, mul);
					int div = dp[i / N * series[j]];
					min = Math.min(min, div);
				}
				dp[i] = min;
			}

		}
		return answer;
	}
}
