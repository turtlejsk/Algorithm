package Coupang2020;

import java.util.ArrayList;

public class Q1 {
	public static void main(String[] args) {
		Q1 q1 = new Q1();

		int N1 = 10;
		int N2 = 14;

		int[] answer = { 6, 4 };
		int[] answer2 = { 5, 8 };

		int[] ret1 = q1.solution(N1);
		int[] ret2 = q1.solution(N2);
		//int[] ret2 = {};
		boolean correct1 = true;
		boolean correct2 = true;
		for (int i = 0; i < ret1.length; i++) {
			if(ret1[i] != answer[i]) {
				correct1 =false;
				break;
			}
		} 
		
		for (int i = 0; i < ret2.length; i++) {
			if(ret2[i] != answer2[i]) {
				correct2 =false;
				break;
			}
		} 
		System.out.println(correct1);
		System.out.println(correct2);
	}

	public int[] solution(int N) {

		ArrayList<Integer> arr = new ArrayList<>();
		for (int i = 2; i <= 10; i++) {
			int digits = (int) (Math.log(N) / Math.log(i));
			int target = N;
			int sum = 1;
			for (int j = digits; j >= 0; j--) {
				int p = (int) Math.pow(i, j);
				int rest = target % p;
				int calc = target / p;
				if (calc != 0) {
					sum *= calc;
				}
				target = rest;
			}
			arr.add(sum);
		}

		int max = 0;
		int loc = 0;
		for (int i = 0; i < arr.size(); i++) {
			if(arr.get(i) >= max) {
				max = arr.get(i);
				loc = i+2;
			}
		}
		int[] answer = {loc,max};
		return answer;
	}

}
