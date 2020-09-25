package Programmers;

import java.util.HashMap;
import java.util.HashSet;

public class GemShopping {

	public static void main(String[] args) {
		String[] gems1 = { "DIA", "EM", "EM", "RUB", "DIA" };
		String[] gems2 = { "AA", "AB", "AC", "AA", "AC" };

		int[] result1 = { 3, 5 };
		int[] result2 = { 1, 3 };

		GemShopping gs = new GemShopping();
		int[] answer1 = gs.solution(gems1);
		boolean correct1 = true;
		System.out.print("{");
		for (int i = 0; i < result1.length; i++) {
			if (answer1[i] != result1[i]) {
				correct1 = false;
			}
			System.out.print(answer1[i]);
		}
		System.out.println("}\n");
		System.out.println("1 : " + correct1);

		int[] answer2 = gs.solution(gems2);
		boolean correct2 = true;
		System.out.print("{");
		for (int i = 0; i < result2.length; i++) {
			if (answer2[i] != result2[i]) {
				correct2 = false;
			}
			System.out.print(answer2[i]);
		}
		System.out.println("}\n");
		System.out.println("2 : " + correct2);

	}

	public int[] solution(String[] gems) {
		int[] answer = {};

		String[] arr = new String[gems.length + 1];

		arr[0] = "";
		HashSet<String> counter = new HashSet<>();

		for (int i = 0; i < gems.length; i++) {
			if (!counter.contains(gems[i])) {
				counter.add(gems[i]);
			}
			arr[i + 1] = gems[i];
		}

		int min = counter.size();
		int start = 1;
		int end = 0;
		HashMap<String, Integer> hm = new HashMap();
		int[] ret = new int[2];
		ret[0] = 1;
		ret[1] = arr.length - 1;

		for (int i = 1; i < arr.length; i++) {
			end = i;
			if (!hm.containsKey(arr[i])) {
				System.out.println("new gem add " + arr[i]);
				hm.put(arr[i], 1);
			} else {
				System.out.println("one more " + arr[i] + ", i = " + i);
				hm.put(arr[end], hm.get(arr[end]) + 1);
			}

			if (hm.size() == min) {
				System.out.println("full " + i);
				while (hm.get(arr[start]) != 1) {
					hm.put(arr[start], hm.get(arr[start]) - 1);
					start++;
				}
				if (end - start < ret[1] - ret[0]) {
					System.out.println("ret[0] = " + ret[0]);
					System.out.println("ret[1] = " + ret[1]);
					System.out.println("start = " + start);
					System.out.println("end = " + end);
					ret[0] = start;
					ret[1] = end;
				}
			}

		}

		answer = ret;
		return answer;
	}

}
