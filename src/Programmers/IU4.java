package Programmers;

public class IU4 {

	public static void main(String[] args) {
		IU4 iu = new IU4();
		int n1 = 15;
		int ret1 = iu.solution(n1);
		int answer1 = 1;
		System.out.println(answer1 == ret1);

		int n2 = 24;
		int ret2 = iu.solution(n2);
		int answer2 = 0;
		System.out.println(answer2 == ret2);

		int n3 = 41;
		int ret3 = iu.solution(n3);
		int answer3 = 2;
		System.out.println(answer3 == ret3);

		int n4 = 2147483647;
		int ret4 = iu.solution(n4);
		int answer4 = 1735;
		System.out.println(answer4 == ret4);

	}

	public int solution(int n) {
		int answer = 0;

		answer = brute(n - 2, 2);

		return answer;
	}

	public int brute(int n, int r) {
		int ret = 0;

		if (n < 1 || 2 * Math.log(n) / Math.log(3) < r) {
			return 0;
		} else if (n == 3 && r == 2) {
			return 1;
		} else if (n == 3 && r == 3) {
			return 0;
		}

		if (n % 3 == 0 && r >= 2) {
			ret += brute(n / 3, r - 2);
		}
		ret += brute(n - 1, r + 1);

		return ret;
	}
}
