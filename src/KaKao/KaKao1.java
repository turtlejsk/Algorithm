package KaKao;


public class KaKao1 {
	public static void main(String[] args) {

		String tc1 = "...!@BaT#*..y.abcdefghijklm";
		String tc2 = "z-+.^.";
		String tc3 = "=.=";
		String tc4 = "123_.def";
		String tc5 = "abcdefghijklmn.p";

		// String answer1 = solution(tc1);
		// String answer2 = solution(tc2);
		String answer3 = solution(tc5);
		// String answer4 = solution(tc4);

		// System.out.println("answer1 = " + answer1);
		// System.out.println("answer2 = " + answer2);
		System.out.println("answer3 = " + answer3);
		// System.out.println("answer4 = " + answer4);

		// System.out.println(removePeriod(tc1));

	}

	public static String solution(String new_id) {
		String answer = "";
		String lowerID = new_id.toLowerCase();

		String filtered = toValid(lowerID);
		String removePeriod = removePeriod(filtered);

		if (removePeriod.length() == 1 && removePeriod.charAt(0) == '.') {
			removePeriod = "a";
		} else if (removePeriod.charAt(0) == '.') {
			removePeriod = removePeriod.substring(1);
		} 

		if (removePeriod.charAt(removePeriod.length() - 1) == '.' && removePeriod.length() == 1) {
			removePeriod = "a";
		} else if (removePeriod.charAt(removePeriod.length() - 1) == '.') {
			removePeriod = removePeriod.substring(0, removePeriod.length());
		} 

		if (removePeriod.length() >= 16) {
			removePeriod = removePeriod.substring(0, 15);
		}

		if (removePeriod.charAt(removePeriod.length() - 1) == '.' && removePeriod.length() == 1) {
			removePeriod = "a";
		} else if (removePeriod.charAt(removePeriod.length() - 1) == '.') {
			removePeriod = removePeriod.substring(0, removePeriod.length() - 1);
		}

		answer = fill(removePeriod);

		return answer;
	}

	public static String toValid(String new_id) {
		String ret = "";
		String filter = "[^0-9a-z\\.\\-\\_]";
		ret = new_id.replaceAll(filter, "");

		return ret;
	}

	public static String removePeriod(String filtered) {
		String ret = "";
		int serial = 0;
		for (int i = 0; i < filtered.length(); i++) {
			if (filtered.charAt(i) == '.') {
				if (serial > 0) {
					continue;
				} else {
					serial++;
					ret += filtered.charAt(i);
				}
			} else {
				ret += filtered.charAt(i);
				serial = 0;
			}
		}
		return ret;
	}

	public static String fill(String removePeriod) {
		String ret = "";
		ret += removePeriod;
		if (removePeriod.length() < 3) {
			char fill = removePeriod.charAt(removePeriod.length() - 1);
			for (int i = 0; i < 3 - removePeriod.length(); i++) {
				ret += fill;
			}
		}
		return ret;
	}

}
