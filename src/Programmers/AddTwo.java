package Programmers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Map.Entry;

public class AddTwo {
	public static void main(String[] args) {
		AddTwo at = new AddTwo();

		int[] numbers1 = { 0, 0 };
		int[] numbers2 = { 5, 0, 2, 7 };

		int[] answer1 = { 0 };
		int[] answer2 = { 2, 5, 7, 9, 12 };

		boolean result1 = true;
		boolean result2 = true;

		int[] ret1 = at.solution(numbers1);
		for (int i = 0; i < answer1.length; i++) {
			if (answer1[i] != ret1[i]) {
				result1 = false;
			}
		}

		System.out.println("result1 : " + result1);

		int[] ret2 = at.solution(numbers2);
		for (int i = 0; i < answer2.length; i++) {
			if (answer2[i] != ret2[i]) {
				result2 = false;
			}
		}

		System.out.println("result2 : " + result2);
	}

	public int[] solution(int[] numbers) {
		int[] answer = {};

		HashSet<Integer> hs = new HashSet<>();

		for (int i = 0; i < numbers.length; i++) {
			for (int j = i + 1; j < numbers.length; j++) {
				hs.add(numbers[i] + numbers[j]);
			}
		}

		ArrayList<Integer> arr = new ArrayList<Integer>();
		for (int i : hs) {
			arr.add(i);
		}

		int[] newAnswer = new int[arr.size()];

		for (int i = 0; i < newAnswer.length; i++) {
			newAnswer[i] = arr.get(i);
		}

		return newAnswer;
	}
}
