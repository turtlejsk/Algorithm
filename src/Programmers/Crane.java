package Programmers;

import java.util.Stack;

public class Crane {

	public static void main(String[] args) {
		int[][] board = { { 0, 0, 0, 0, 0 }, { 0, 0, 1, 0, 3 }, { 0, 2, 5, 0, 1 }, { 4, 2, 4, 4, 2 },
				{ 3, 5, 1, 3, 1 } };

		int[][] board2 = { { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 }, { 1, 1, 1, 1, 1 },
				{ 1, 1, 1, 1, 1 } };

		int[] moves = { 1, 5, 3, 5, 1, 2, 1, 4 };
		int[] moves2 = { 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, 1, 2, 3, 4, 5 };
		Crane c = new Crane();
		int answer = c.solution(board, moves);
		System.out.println(answer);
		System.out.println(answer == 4);
		int answer2 = c.solution(board2, moves2);
		System.out.println(answer2);
		System.out.println(answer2 == 24);
	}

	public int solution(int[][] board, int[] moves) {
		int answer = 0;

		int len = board.length;
		Stack<Integer> stack = new Stack();

		int[][] dolls = new int[len][len];

		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len; j++) {
				dolls[i][len - j - 1] = board[j][i];
			}
		}

		// 첫 빈칸의 좌표
		int[] top = new int[len];

		int laneNum = 0;
		for (int[] lane : dolls) {
			for (int i = 0; i < len; i++) {
				if (lane[i] == 0) {
					top[laneNum] = i;
					break;
				} else {
					top[laneNum] = len;
				}
			}
			laneNum++;
		}

		for (int i = 0; i < moves.length; i++) {
			int lane = moves[i] - 1;

			if (top[lane] == 0) {

			} else {
				int doll = dolls[lane][top[lane] - 1];
				System.out.println("doll :" + doll);
				dolls[lane][top[lane] - 1] = 0;

				top[lane] -= 1;

				if (!stack.isEmpty()) {
					int dollStack = stack.peek();

					if (dollStack == doll) {
						stack.pop();
						answer += 2;
					} else {
						stack.push(doll);
					}

				} else {
					stack.push(doll);
				}

			}
		}

		return answer;
	}
}
