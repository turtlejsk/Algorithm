package Programmers;

import static org.junit.Assert.assertEquals;

import org.apache.poi.util.SystemOutLogger;
import org.junit.Test;

public class Cookie {

	@Test
	public void test() {
		int[] cookie1 = { 1, 1, 2, 3 };
		int[] cookie2 = { 1, 2, 4, 5 };

		int result1 = 3;
		int result2 = 0;

		Cookie c = new Cookie();
		int answer1 = c.solution(cookie1);
		// int answer2 = c.solution(cookie2);

		assertEquals(result1, answer1);
		// assertEquals(result2, answer2);
	}

	public int solution(int[] cookie) {
		int answer = -1;

		int[] cookies = new int[cookie.length + 1];

		for (int i = 0; i < cookies.length - 1; i++) {
			cookies[i + 1] = cookie[i];
		}
		cookies[0] = 0;
		int length = cookies.length;

		int r = 0;
		// int m = 0;

		int rSum = 0;
		int rSumTmp = 0;
		for (int i = 1; i < length; i++) {
			int l = 1;
			r = i;
			System.out.println("r = " + r);
			rSum += cookies[r];
			System.out.println("rSum = " + rSum);
			System.out.println();
			int lSum = 0;
			while (l < r) {
				lSum = 0;
				// rSumTmp = rSum;
				// m = l;
				rSumTmp = rSum;
				for (int m = 1; m < r; m++) {
					System.out.println();
					System.out.println("m = " + m);
					if (m > l) {
						System.out.println();
						System.out.println("if");
						System.out.println("rSumTmp 빼기");
						
						System.out.println(cookies[m]);
						rSumTmp -= cookies[m];
						System.out.println(rSumTmp);
					} else {
						System.out.println();
						System.out.println("else");
						lSum += cookies[m];
						System.out.println("lSum = " + lSum);
						System.out.println("rSumTmp = " + rSumTmp);
						if (lSum == rSumTmp) {
							System.out.println("Same");
							System.out.println("Sum = " + lSum);
							answer = Math.max(lSum, answer);
						}
					}
				}
				l++;
			}

			System.out.println("===========================");
		}

		return answer;
	}
}
