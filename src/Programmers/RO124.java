package Programmers;

public class RO124 {
	public static void main(String[] args) {
		RO124 r = new RO124();
		System.out.println("answer: " + r.solution(1));
	}

	public String solution(int n) {
		String answer = "";
		StringBuffer sb = new StringBuffer();

		int sum = 0;
		int logMax = (int) (Math.log(500000000) / Math.log(3));
		int digit = 0;
		int rangeStart = 0;
		for (int i = 1; i < logMax; i++) {
			rangeStart = sum + 1;
			sum += Math.pow(3, i);

			if (sum >= n) {
				digit = i;
				break;
			}
		}
		System.out.println(digit);
		n -= rangeStart;

		while (digit > 0) {

			int tok = (int) (n / Math.pow(3, digit - 1));
			n -= Math.pow(3, digit - 1) * tok;
			digit -= 1;

			switch (tok) {
			case 0:
				sb.append("1");
				break;
			case 1:
				sb.append("2");
				break;
			case 2:
				sb.append("4");
				break;
			}
		}
		answer = sb.toString();
		System.out.println(answer);
		return answer;
	}
}
