package Programmers;

import java.util.Arrays;

public class QuadZip {
	public static void main(String[] args) {
		QuadZip qz = new QuadZip();

		int[][] arr1 = { { 1, 1, 0, 0 }, { 1, 0, 0, 0 }, { 1, 0, 0, 1 }, { 1, 1, 1, 1 } };

		int[] ret1 = qz.solution(arr1);

		int[][] arr2 = { { 1, 1, 1, 1, 1, 1, 1, 1 }, { 0, 1, 1, 1, 1, 1, 1, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1 },
				{ 0, 1, 0, 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0, 0, 1, 1 }, { 0, 0, 0, 0, 0, 0, 0, 1 },
				{ 0, 0, 0, 0, 1, 0, 0, 1 }, { 0, 0, 0, 0, 1, 1, 1, 1 } };

		int[] ret2 = qz.solution(arr2);

		System.out.println(ret1[0] + ", " + ret1[1]);
		System.out.println(ret2[0] + ", " + ret2[1]);
	}

	public int[] solution(int[][] arr) {
		int[] answer = {};
		int[][] map = new int[arr.length][arr.length];
		Arrays.fill(map, -1);

		return answer;
	}

	public int[][] zip(int[][] arr, int range, int x, int y) {
		if(range == 1) {
			
		}
		int ret[][] = arr;
		return ret;
	}

}
