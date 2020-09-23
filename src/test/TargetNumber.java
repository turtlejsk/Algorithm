package test;

import java.util.ArrayList;

public class TargetNumber {

	public static void main(String[] args) {
		int[] numbers = { 1, 1, 1, 1, 1 };
		int target = 3;

		System.out.println(solution(numbers, target));
	}

	public static int solution(int[] numbers, int target) {
		int answer = 0;

		ArrayList<Integer> answerList = new ArrayList<>();
		search(numbers, target, 0, answerList);

		answer = answerList.size();

		return answer;
	}

	// acc = 여태까지 결과
	// option = +/-
	// floor = 현재 층수
	public static void search(int[] numbers, int target, int floor, ArrayList<Integer> answerList) {
		if (floor == numbers.length) {
			int ret = 0;
			for (int number : numbers) {
				ret += number;
			}
			if (ret == target) {
				answerList.add(ret);
			}
		} else {
			numbers[floor] *= 1;
			search(numbers, target, floor + 1, answerList);
			numbers[floor] *= -1;
			search(numbers, target, floor + 1, answerList);
		}
	}
}
