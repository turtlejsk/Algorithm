package test;

import java.util.ArrayList;

public class SAT {

	public static void main(String[] args) {
		int[] answers = { 1, 2, 3, 4, 5 };

		ArrayList<Integer> arr = new ArrayList<>();
		arr.stream().mapToInt(i -> i.intValue()).toArray();
		System.out.println(solution(answers));
		// for(int i : answers) {
		//
		// System.out.println(i);
		// }
	}

	public static int[] solution(int[] answers) {
		int[] answer = {};
		int[] patternA = { 1, 2, 3, 4, 5 }; // 5
		int[] patternB = { 2, 1, 2, 3, 2, 4, 2, 5 }; // 8
		int[] patternC = { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 }; // 10
		int idxA = 0;
		int idxB = 0;
		int idxC = 0;
		int correctA = 0;
		int correctB = 0;
		int correctC = 0;
		for (int i = 0; i < answers.length; i++) {

			if (patternA[idxA] == answers[i]) {
				correctA++;
			}
			idxA++;
			idxA %= 5;
			if (patternB[idxB] == answers[i]) {
				correctB++;
			}
			idxB++;
			idxB %= 8;
			if (patternC[idxC] == answers[i]) {
				correctC++;
			}
			idxC++;
			idxC %= 10;

		}
		
	        
		return answer;
	}
	

}
