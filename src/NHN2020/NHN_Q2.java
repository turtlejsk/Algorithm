package NHN2020;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class NHN_Q2 {
	@Test
	public void test() {

		NHN_Q2 n2 = new NHN_Q2();

		int day1 = 2;
		int width1 = 6;
		int[][] blocks1 = { { 6, 2, 11, 0, 3, 5 }, { 6, 3, 0, 9, 0, 5 } };
		n2.solution(day1, width1, blocks1);

		int day2 = 3;
		int width2 = 10;
		int[][] blocks2 = { { 6, 12, 0, 2, 8, 4, 0, 7, 3, 6 }, { 6, 1, 3, 0, 2, 8, 0, 0, 13, 8 },
				{ 6, 3, 0, 10, 6, 5, 7, 0, 0, 3 } };
		n2.solution(day2, width2, blocks2);

	}

	private void solution(int day, int width, int[][] blocks) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.

		int[] cement = new int[width];
		int[] onlyBlock = new int[width];
		Arrays.fill(cement, 0);
		Arrays.fill(onlyBlock, 0);

		for (int i = 0; i < day; i++) {
			int left = 0;
			int max = 0;
			int right = 0;
			// 벽돌 쌓고 높이측정
			for (int j = 0; j < width; j++) {
				onlyBlock[j] += blocks[i][j];
				cement[j] += blocks[i][j];
				if (j == 0) {
					left = cement[j];
				} else if (j == width - 1) {
					right = cement[j];
				}
				if (cement[j] > max) {
					max = cement[j];
				}
			}

			if (left == max) {
				int localMin = right;
				for (int j = width - 2; j >= 0; j--) {
					if (cement[j] < localMin) {
						cement[j] = localMin;
					} else if (cement[j] > localMin) {
						localMin = cement[j];
					}
				}
			} else if (right == max) {
				int localMin = left;
				for (int j = 1; j < width; i++) {
					if (cement[j] < localMin) {
						cement[j] = localMin;
					} else if (cement[j] > localMin) {
						localMin = cement[j];
					}
				}
			} else {
				int localMin = left;
				int leftStop = -1;
				int rightStop = -1;

				for (int j = 1; j < width; j++) {
					if (cement[j] < localMin) {
						cement[j] = localMin;
					} else if (cement[j] == max) {
						leftStop = j;
						break;
					} else if (cement[j] > localMin) {
						localMin = cement[j];
					}
				}

				localMin = right;
				for (int j = width - 2; j >= 0; j--) {
					if (cement[j] < localMin) {
						cement[j] = localMin;
					} else if (cement[j] == max) {
						rightStop = j;
						break;
					} else if (cement[j] > localMin) {
						localMin = cement[j];
					}
				}

				if (leftStop != rightStop && leftStop != -1 && rightStop != -1) {
					for (int j = leftStop; j <= rightStop; j++) {
						cement[j] = max;
					}
				}

			}

		}
		int cementSum = 0;
		int originalSum = 0;
		for (int i = 0; i < width; i++) {
			cementSum += cement[i];
			originalSum += onlyBlock[i];
		}

		System.out.println(cementSum - originalSum);

	}

}
