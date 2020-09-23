package test;

import java.util.*;

import test.asdf.Num;

public class Solution {

	public Solution() {

	}

	public String answer(int[] numbers) {
		return solution(numbers);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] numbers = { 41, 403 };
		// int[] numbers = { 471, 45, 441, 47, 4 };
		// int[] numbers = { 69, 63, 34 };
		// int[] numbers = { 2, 200, 20 };
		Solution s = new Solution();
		System.out.println(s.answer(numbers));

	}

	public String solution(int[] numbers) {
		String answer = "";

		PriorityQueue<Num> pq = new PriorityQueue<Num>();

		for (int i = 0; i < numbers.length; i++) {
			double log = Math.log10(numbers[i]);
			double order;
			Num n;
			if (log == 3) {
				order = 1.0;
				n = new Num(order, numbers[i]);
				pq.offer(n);
			} else if (2 <= log && log < 3) {
				order = (double) numbers[i] / 100.0;
				n = new Num(order, numbers[i]);
				pq.offer(n);

			} else if (1 <= log && log < 2) {
				int div = numbers[i] / 10;
				int resid = numbers[i] % 10;
				if (resid < div) {
					resid = div;
				} else {

				}
				order = (numbers[i] * 10) + resid;
				order /= 100.0;
				n = new Num(order, numbers[i]);
				pq.offer(n);
			} else {
				order = (double) numbers[i];
				order *= 1.11;
				n = new Num(order, numbers[i]);
				pq.offer(n);
			}
		}

		while (!pq.isEmpty()) {
			Num number = pq.poll();
			int token = number.original;
			String tokenStr = String.valueOf(token);
			System.out.println("tokenStr: " + tokenStr);
			System.out.println("order : " + number.order);
			answer += tokenStr;
		}

		String zeros = "";
		for (int i = 0; i < numbers.length; i++) {
			zeros += "0";
		}
		if (answer.equals(zeros)) {
			return "0";
		}

		return answer;
	}

	class Num implements Comparable<Num> {
		double order;
		int original;

		public Num(double order, int original) {
			if (original == 9 || original == 99 || original == 999) {
				order = 10.0;
			}
			this.order = order;
			this.original = original;
		}

		@Override
		public int compareTo(Num num) {
			if (this.order > num.order) {
				return -1;
			} else if (this.order < num.order) {
				return 1;
			} else {
				return 0;
			}
		}
	}

}
