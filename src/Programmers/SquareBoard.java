package Programmers;

import java.util.LinkedList;

public class SquareBoard {

	public static void main(String[] args) {
		SquareBoard sb = new SquareBoard();

		int[][] board = { { 0, 1, 1, 1 }, { 1, 1, 1, 1 }, { 1, 1, 1, 1 }, { 0, 0, 1, 0 } };
		int[][] board2 = { { 0, 0, 1, 1 }, { 1, 1, 1, 1 } };

		// int answer1 = sb.solution(board);
		// System.out.println(answer1);

		int answer2 = sb.solution(board2);
		System.out.println(answer2);
	}

	public int solution(int[][] board) {
		int answer = 0;
		int yLen = board.length;
		int xLen = board[0].length;

		int maxLen = Math.min(yLen, xLen);
		answer = squareCheck(0, 0, maxLen, board);

		return answer;
	}

	public int squareCheck(int y, int x, int size, int[][] board) {

		boolean sq = true;

		for (int i = y; i < y + size; i++) {
			for (int j = x; i < x + size; i++) {
				if (board[i][j] == 0) {
					sq = false;
					break;
				}
			}
		}

		if (sq) {
			System.out.println("(" + y + ", " + x + ") has square, size = " + size * size);
			return size * size;
		} else {
			System.out.println("square started from (" + y + ", " + x + ") with size: " + size + " cannot make square");
			int searchY = 0;
			int searchX = 0;
			// shift
			// 세로로 긴 경우
			if (board.length > board[0].length) {
				System.out.println("세로로 김");
				searchY = squareCheck(y + 1, x, size, board);
				searchX = squareCheck(y, x + 1, size - 1, board);
			} else if (board.length < board[0].length) {
				System.out.println("가로로 김");
				searchY = squareCheck(y + 1, x, size - 1, board);
				searchX = squareCheck(y, x + 1, size, board);
			} else {
				searchY = squareCheck(y + 1, x, size - 1, board);
				searchX = squareCheck(y, x + 1, size - 1, board);
			}

			int max = Math.max(searchY, searchX);

			return max;
		}
	}

}
