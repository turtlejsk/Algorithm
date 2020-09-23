package KaKao;

public class Bracket {
	public static void main(String[] args) {

		String s1 = "(()())()";
		String s2 = ")(";
		String s3 = "()))((()";

		//String answer1 = solution(s1);
		//String answer2 = solution(s2);
		String answer3 = solution(s3);
		System.out.println("answer 3: " + answer3);

	}

	public static String solution(String p) {
		String answer = "";

		answer = balanceStack(p);

		return answer;
	}

	public static int validIndex(String s) {
		int ret = 0;
		int idx = 0;
		for (int i = 0; i < s.length(); i++) {
			if (s.charAt(i) == '(') {
				ret++;
			} else {
				ret--;
			}
			if (ret == 0) {
				ret = idx;
				break;
			}
			idx++;
		}
		return ret;
	}

	public static String balanceStack(String s) {
		String ret = "";
		System.out.println("s = " + s);
		if (s.length() == 0) {
			return ret;
		}
		int valIdx = validIndex(s);
		String u = "";
		String v = "";

		u = s.substring(0, valIdx + 1);
		v = s.substring(valIdx + 1, s.length());

		System.out.println("u = " + u);
		System.out.println("v = " + v);

		if ((validIndex(u) == u.length() - 1) && (validIndex(v) == v.length() - 1)) {
			return s;
		}

		if (validIndex(u) == u.length() - 1) {
			ret = u + balanceStack(v);
		} else {
			ret += "(";
			ret += balanceStack(v);
			ret += ")";
			String reverse = u.substring(1, u.length() - 1);
			ret += reverse(reverse);
		}
		return ret;
	}

	public static String reverse(String reverse) {
		String ret = "";
		for (int i = 0; i < reverse.length(); i++) {
			if (reverse.charAt(i) == '(') {
				ret += ")";
			} else {
				ret += "(";
			}
		}
		return ret;
	}
}
