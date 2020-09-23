package test;

import java.util.*;

public class ExpressN {

	public ExpressN() {

	}

	public static void main(String[] args) {
		int N = 4;
		int number = 17;
		ExpressN e = new ExpressN();

		int answer = e.solution(N, number);
		System.out.println(answer);

	}

	public int solution(int N, int number) {
		int answer = 0;

		int[] cache = new int[40];

		ArrayList<Integer> cacheList = new ArrayList<>();

		for (int i = 0; i < cache.length; i++) {
			cache[i] = 9;
			cacheList.add(9);
		}

		cache[0] = 2;
		cache[2] = 4;
		cache[1] = 2;
		cache[N] = 1;
		cache[N + N] = 2;
		cache[N * N] = 2;
//		cache[N * 11] = 2;
//		cache[N * 111] = 3;
//		cache[N * 1111] = 4;

		cacheList.set(0, 2);
		cacheList.set(2, 4);
		cacheList.set(1, 2);
		cacheList.set(N, 1);
		cacheList.set(N + N, 2);
		cacheList.set(N * N, 2);
//		cacheList.set(N * 11, 2);
//		cacheList.set(N * 111, 3);
//		cacheList.set(N * 1111, 4);
//		if (N <= 2) {
//			cache[N * 11111] = 5;
//			cacheList.add(N * 11111, 5);
//		}

		int count = 0;
		Calculator c = new Calculator(cache, cacheList);
		answer = c.express(N, number, cache, count);
		return answer;
	}

	class Calculator {
		int N;
		int number;
		int[] cache;
		ArrayList<Integer> cacheList;

		public Calculator(int[] cache, ArrayList<Integer> cacheList) {
			this.cache = cache;
			this.cacheList = cacheList;
		}

		public void printCache() {
			for (int i = 0; i < 20; i++) {
				System.out.println(cache[i]);
			}
		}

		public void printCacheList() {
			int idx = 0;
			for (int c : this.cacheList) {
				System.out.println(idx + "th = " + c);
				idx++;
			}
		}

		public int express(int N, int number, int[] cache, int count) {
			System.out.printf("express(%d, %d)", N, number);
			System.out.println();
			//printCacheList();
			// printCache();
			if (number > cache.length || number < 0 || count >= 8) {
				// System.out.println("Out of boundary");
				return 100;
			}
			if (cache[number] != 9) {
				System.out.println("Use cache, return " + cache[number]);
				return cache[number];
			} else {
				for (int c : cacheList) {
					// System.out.println("cacheList c = " + c);
					int newVal = 0;
					int mul = 100;
					if (number % c == 0) {
						mul = express(N, number / c, cache, count + 1);
						newVal = Math.min(mul + 1, cache[number]);
						cache[number] = newVal;
						cacheList.set(number, newVal);
						System.out.printf("number = %d, value = %d", number, Math.min(cacheList.get(number), newVal));
						System.out.println();
						// System.out.printf("cacheList.set(%d)", newVal);
						// System.out.println("cache mul");
						// System.out.printf("cache[%d] = %d", number, Math.min(mul + 1,
						// cache[number]));
						// System.out.println();
					}
					
					int add = 100;
					if (number - c > 0) {
						add = express(N, number - c, cache, count + 1);
						newVal = Math.min(add + 1, cache[number]);
						cache[number] = newVal;

						cacheList.set(number, Math.min(cacheList.get(number), newVal));
						System.out.printf("number = %d, value = %d", number, Math.min(cacheList.get(number), newVal));
						System.out.println();
						// System.out.println("cache add");
						// System.out.printf("cache[%d] = %d", number, Math.min(add + 1,
						// cache[number]));
						// System.out.println();
					}

					int sub = express(N, number + c, cache, count + 1);
					newVal = Math.min(sub + 1, cache[number]);
					cache[number] = newVal;
					Math.min(cacheList.get(number), newVal);
					System.out.printf("cacheList.set(%d)", newVal);
					System.out.println();
					cacheList.set(number, Math.min(cacheList.get(number), newVal));
					// System.out.println("cache sub");
					// System.out.printf("cache[%d] = %d", number, Math.min(sub + 1,
					// cache[number]));
					// System.out.println();

					int div = express(N, number * c, cache, count + 1);
					newVal = Math.min(div + 1, cache[number]);
					cache[number] = newVal;
					cacheList.set(number, Math.min(cacheList.get(number), newVal));
					// System.out.printf("cacheList.set(%d)", newVal);
					// System.out.println("cache div");
					// System.out.printf("cache[%d] = %d", number, Math.min(div + 1,
					// cache[number]));
					// System.out.println();
				}

				int mul = 100;
				if (number % N == 0) {
					mul = express(N, number / N, cache, count + 1);

					cache[number] = Math.min(mul + 1, cache[number]);
					// System.out.println("cache mul");
					// System.out.printf("cache[%d] = %d", number, Math.min(mul + 1,
					// cache[number]));
					// System.out.println();
				}

				int add = 100;
				if (number - N > 0) {
					add = express(N, number - N, cache, count + 1);
					cache[number] = Math.min(add + 1, cache[number]);
					// System.out.println("cache add");
					// System.out.printf("cache[%d] = %d", number, Math.min(add + 1,
					// cache[number]));
					// System.out.println();
				}

				int sub = express(N, number + N, cache, count + 1);
				cache[number] = Math.min(sub + 1, cache[number]);
				System.out.println("cache sub");
				System.out.printf("cache[%d] = %d", number, Math.min(sub + 1, cache[number]));
				System.out.println();

				int div = express(N, number * N, cache, count + 1);
				cache[number] = Math.min(div + 1, cache[number]);
				System.out.println("cache div");
				System.out.printf("cache[%d] = %d", number, Math.min(div + 1, cache[number]));
				System.out.println();
				return cache[number];
			}

		}
	}
}
