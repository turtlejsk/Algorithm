package Coupang2020;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class Q3 {
	public static void main(String[] args) {
		Q3 q3 = new Q3();

		int k1 = 3;
		int k2 = 2;

		int[] score1 = { 24, 22, 20, 10, 5, 3, 2, 1 };
		int[] score2 = { 1300000000, 700000000, 668239490, 618239490, 568239490, 568239486, 518239486, 157658638,
				157658634, 100000000, 100 };

		int answer1 = 3;
		int answer2 = 4;

		int ret1 = q3.solution(k1, score1);

		System.out.println(ret1);
		System.out.println(ret1 == answer1);
		int ret2 = q3.solution(k2, score2);

		System.out.println(ret2);
		System.out.println(ret2 == answer2);
	}

	public int solution(int k, int[] score) {
		int answer = 0;

		HashMap<Integer, LinkedList<Integer>> hm = new HashMap();

		for (int i = 1; i < score.length; i++) {
			int gap = score[i] - score[i - 1];
			System.out.println("gap[" + i + "] = " + gap);
			if (!hm.containsKey(gap)) {
				hm.put(gap, new LinkedList());
				hm.get(gap).add(i);
			} else {
				hm.get(gap).add(i);
				System.out.println("list size = " + hm.get(gap));
			}
		}

		boolean[] safe = new boolean[score.length];
		Arrays.fill(safe, true);
		for (Entry<Integer, LinkedList<Integer>> entry : hm.entrySet()) {
			if (entry.getValue().size() >= k) {
				System.out.println(entry.getKey() + " is repeated " + entry.getValue().size() + " times");
				for (int i : entry.getValue()) {
					safe[i - 1] = false;
					safe[i] = false;
				}
			}
		}

		for (boolean b : safe) {
			if (b) {
				answer++;
			}

		}

		return answer;
	}

}
