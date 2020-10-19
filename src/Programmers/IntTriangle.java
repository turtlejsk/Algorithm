package Programmers;

import java.util.Arrays;

public class IntTriangle {
	public static void main(String[] args) {
		IntTriangle it = new IntTriangle();
		int[][] triangle = { { 7 }, { 3, 8 }, { 8, 1, 0 }, { 2, 7, 4, 4 }, { 4, 5, 2, 6, 5 } };
		int answer = it.solution(triangle);
		System.out.println(answer);
	}

	public int solution(int[][] triangle) {
		int answer = 0;
		int[][] map = new int[triangle.length + 1][triangle.length + 1];

		for (int i = 0; i < triangle.length; i++) {
			Arrays.fill(map[i], -1);
		}
		map[1][1] = triangle[0][0];

		for (int i = 2; i < map.length; i++) {
			for (int j = 1; j <= i; j++) {
				// y = i, x = j
				map[i][j] = triangle[i-1][j-1] + Math.max(map[i - 1][j], map[i - 1][j - 1]);
			}
		}
		
		for (int i = 0; i < map.length; i++) {
			for (int j = 0; j < map.length; j++) {
				System.out.print(map[i][j]);
			}
			System.out.println();
		}

		for (int i = 0; i < triangle.length; i++) {
			answer = Math.max(answer, map[triangle.length][i]);
		}

		return answer;
	}

}
