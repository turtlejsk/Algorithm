package Programmers;

import java.util.*;

public class Hindex {
	public static void main(String[] args) {

		// int[] citations = { 20, 21, 22, 23, 24 };
		int[] citations = { 3, 0, 6, 1, 5 };
		System.out.println("answer : " + solution(citations));
		
	}

	public static int solution(int[] citations) {
		int answer = 0;

		Arrays.sort(citations);

		for (int i = citations.length; i > 0; i--) {
			int h = citations[i - 1];
			System.out.println("h : " + h);
			int overH = 0;
			for (int j = citations.length; j > 0; j--) {

				if (h <= citations[j - 1]) {
					overH++;
				} else if (h > citations[j - 1]) {
					break;
				}

			}
			System.out.println("overH : " + overH);
			if (overH >= i && answer < h) {
				answer = overH;
			}
		}

		return answer;
	}
}
