package Programmers;

public class KeyPad {
	public static void main(String[] args) {
		int[] numbers1 = { 1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5 };
		int[] numbers2 = { 7, 0, 8, 2, 8, 3, 1, 5, 7, 6, 2 };
		int[] numbers3 = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 0 };

		String hand1 = "right";
		String hand2 = "left";
		String hand3 = "right";

		KeyPad kp = new KeyPad();

		String answer2 = kp.solution(numbers2, hand2);

		System.out.println("answer2 = " + answer2);
		System.out.println(answer2.equals("LRLLRRLLLRR"));
		System.out.println("---------------------------");

		String answer3 = kp.solution(numbers3, hand3);
		System.out.println("answer3 = " + answer3);
		System.out.println(answer3.equals("LLRLLRLLRL"));
	}

	public String solution(int[] numbers, String hand) {
		String answer = "";

		int left = 7;
		int right = 8;

		int[][] map = { { 0, 4, 3, 4, 3, 2, 3, 2, 1, 2 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 3, 1, 0, 1, 2, 1, 2, 3, 2, 3 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 2, 2, 1, 2, 1, 0, 1, 2, 1, 2 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 }, { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },
				{ 1, 3, 2, 3, 2, 1, 2, 1, 0, 1 } };

		for (int i = 0; i < numbers.length; i++) {

			if (numbers[i] % 3 == 1) {
				answer = answer.concat("L");
				left = numbers[i];
			} else if (numbers[i] % 3 == 0 && numbers[i] != 0) {
				answer = answer.concat("R");
				right = numbers[i];
			} else {
				int leftDis = map[numbers[i]][left];
				int rightDis = map[numbers[i]][right];
				System.out.println("number = " + numbers[i]);
				System.out.println("left = " + left);
				System.out.println("right = " + right);
				System.out.println("leftDis = " + leftDis);
				System.out.println("rightDis = " + rightDis);

				if (leftDis < rightDis) {
					answer = answer.concat("L");
					left = numbers[i];
					System.out.println("use Left");
				} else if (leftDis > rightDis) {
					answer = answer.concat("R");
					right = numbers[i];
					System.out.println("use Right");
				} else if (leftDis == rightDis) {
					if (hand.equals("left")) {
						answer = answer.concat("L");
						left = numbers[i];
						System.out.println("use Left");
					} else {
						answer = answer.concat("R");
						right = numbers[i];
						System.out.println("use Right");
					}
				}
			}

		}

		return answer;
	}

}
