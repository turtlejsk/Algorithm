package KaKao;

import java.util.*;

public class CompressWord {

	public static void main(String[] args) {
		String s1 = "aabbaccc";
		String s2 = "ababcdcdababcdcd";
		String s3 = "abcabcdede";
		String s4 = "abcabcabcabcdededededede";
		String s5 = "xababcdcdababcdcd";
		String s6 = "BBAABAAAAB";

		System.out.println(solution(s1));
		System.out.println(solution(s2));
		System.out.println(solution(s3));
		System.out.println(solution(s4));
		System.out.println(solution(s5));
		System.out.println(solution(s6));
	}

	public static int solution(String s) {

		int answer = 0;

		int minLength = s.length();
		for (int i = 1; i <= (s.length() / 2); i++) {
			int tempMin = s.length();
			int start = 0;
			int end = start + i;
			String pattern = s.substring(start, end);
			HashSet<String> patterns = new HashSet();
			while (end + i - 1 < s.length()) {
				start = end;
				end = start + i;

				String nextPattern = s.substring(start, end);

				while (pattern.equals(nextPattern) && end <= s.length()) {

					patterns.add(pattern);
					tempMin -= i;
					start = end;
					end = start + i;
					if (end > s.length()) {
						break;
					}

					nextPattern = s.substring(start, end);
				}
				pattern = nextPattern;

			}

			tempMin += patterns.size();

			if (tempMin < minLength) {
				minLength = tempMin;
			}
		}
		answer = minLength;
		return answer;
	}
}
