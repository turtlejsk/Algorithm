package Programmers;

public class Match {

	public static void main(String[] args) {
		int n = 8;
		int a = 1;
		int b = 2;
		int answer = 1;

		Match m = new Match();
		int result = m.solution(n, a, b);
		System.out.println(result);
		System.out.println(answer == result);
	}

	public int solution(int n, int a, int b) {
		int answer = 1;

		int head = 0;
		int tail = n;
		int count = 0;

		if (a > b) {
			int tmp = a;
			a = b;
			b = tmp;
		}

		while ((a - (head + tail) / 2) * (b - (head + tail) / 2) > 0) {
			if ((a - (head + tail) / 2) < 0) {
				tail = (head + tail) / 2;
				count++;

			} else {
				head = (head + tail) / 2;
				count++;
			}
		}
		
		if((head+tail)/2 == a || (head+tail)/2 == b) {
			count++;
		}
		answer = (int) (Math.log(n) / Math.log(2)) - count;

		return answer;
	}
}
