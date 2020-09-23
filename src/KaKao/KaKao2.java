package KaKao;

import java.util.*;

public class KaKao2 {

	public KaKao2() {

	}

	public static void main(String[] args) {

		String[] tc1 = { "ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH" };
		String[] tc2 = { "ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD" };
		String[] tc3 = { "XYZ", "XWY", "WXA" };

		int[] course1 = { 2, 3, 4 };
		int[] course2 = { 2, 3, 5 };
		int[] course3 = { 2, 3, 4 };

		KaKao2 k2 = new KaKao2();
		String[] answer1 = k2.solution(tc1, course1);
		// String[] answer2 = solution(tc2, course2);
		// String[] answer3 = solution(tc3, course3);

		for (String s : answer1) {
			System.out.println(s);
		}

	}

	public String[] solution(String[] orders, int[] course) {
		String[] answer = {};

		Map<String, Integer> map = new HashMap<>();
		HashSet<String> orderSet = new HashSet<>();
		HashSet<Integer> courseSet = new HashSet<>();
		for (int i = 0; i < orders.length; i++) {

			String[] s = new String[orders[i].length()];

			for (int j = 0; j < orders[i].length(); j++) {
				s[j] = String.valueOf(orders[i].charAt(j));
			}

			Combination cmb = new Combination(s, orderSet, map);
			for (int j = 0; j < orders[i].length(); j++) {
				cmb.doCombination(s.length, j, 0);
			}
		}

		for (int i = 0; i < course.length; i++) {
			courseSet.add(course[i]);
		}


		Map<String, Integer> survive = new HashMap<String, Integer>();

		for (Map.Entry<String, Integer> entry : map.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			if (value > 1 && courseSet.contains(key.length())) {
				survive.put(key, value);
			}
		}

		int[] courseMax = new int[course.length];
		for (int i = 0; i < courseMax.length; i++) {
			courseMax[i] = 0;
		}

		for (Map.Entry<String, Integer> entry : survive.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			for (int i = 0; i < course.length; i++) {
				if (course[i] == key.length() && courseMax[i] < value) {
					courseMax[i] = value;
				}
			}
		}

		ArrayList<String> answerList = new ArrayList<>();
		for (Map.Entry<String, Integer> entry : survive.entrySet()) {
			String key = entry.getKey();
			int value = entry.getValue();
			for (int i = 0; i < courseMax[i]; i++) {
				if (courseMax[i] == value && course[i] == key.length()) {
					answerList.add(key);
				}
			}
		}

		
		String[] newAnswer = new String[answerList.size()];

		for (int i = 0; i < newAnswer.length; i++) {
			newAnswer[i] = answerList.get(i);
		}

		answer = newAnswer;
		return answer;
	}

	class Combination {
		private String[] arr;
		private Stack<String> st;
		private HashSet<String> hs;
		private Map<String, Integer> map;

		public Combination(String[] arr, HashSet<String> set, Map<String, Integer> map) {
			this.arr = arr;
			st = new Stack<String>();
			this.hs = set;
			this.map = map;
		}

		public void save() {
			String s = "";
			for (int i = 0; i < st.size(); i++) {
				s += st.get(i);
			}
			hs.add(s);
			if (map.containsKey(s)) {
				map.put(s, map.get(s) + 1);
			} else {
				map.put(s, 1);
			}

		}

		public void doCombination(int n, int r, int index) {
			if (r == 0) {
				save();
				return;
			} else if (n == r) {
				for (int i = 0; i < n; i++) {
					st.add(arr[index + i]);

				}
				save();
				for (int i = 0; i < n; i++)
					st.pop();
			} else {
				st.add(arr[index]);
				doCombination(n - 1, r - 1, index + 1);
				st.pop();
				doCombination(n - 1, r, index + 1);

			}
		}
	}

}
