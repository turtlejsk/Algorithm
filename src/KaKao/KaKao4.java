package KaKao;

import java.util.*;

public class KaKao4 {
	public static void main(String[] args) {

		int n1 = 6;
		int n2 = 7;
		int n3 = 6;

		int s1 = 4;
		int s2 = 3;
		int s3 = 4;

		int a1 = 6;
		int a2 = 4;
		int a3 = 5;
		int b1 = 2;
		int b2 = 1;
		int b3 = 6;

		int[][] fares1 = { { 4, 1, 10 }, { 3, 5, 24 }, { 5, 6, 2 }, { 3, 1, 41 }, { 5, 1, 24 }, { 4, 6, 50 },
				{ 2, 4, 66 }, { 2, 3, 22 }, { 1, 6, 25 } };

		int answer1 = solution(n1, s1, a1, b1, fares1);
		// answer2 = solution(tc2);
		// answer3 = solution(tc3);
		// answer4 = solution(tc4);
		System.out.println("answer1 = " + answer1);
		// System.out.println("answer2 = " + answer2);
		// System.out.println("answer3 = " + answer3);
		// System.out.println("answer4 = " + answer4);

	}

	public static int solution(int n, int s, int a, int b, int[][] fares) {
		int answer = 0;

		return answer;

	}
	
	class Graph{
		
		int[][] map;
		int[] visited;

		public Graph() {
			
		}
		
		public void drawMap() {
			
		}
		
		public void dfs(int start) {
			this.visited[start] = 1;
		
		}
	}
}
