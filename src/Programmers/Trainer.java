package Programmers;

import java.util.Arrays;

public class Trainer {

	public static void main(String[] args) {
		Trainer t = new Trainer();

		int n1 = 5;
		int n2 = 5;
		int n3 = 3;

		int[] lost1 = { 2, 4 };
		int[] lost2 = { 2, 4 };
		int[] lost3 = { 3 };

		int[] reserve1 = { 1, 3, 5 };
		int[] reserve2 = { 3 };
		int[] reserve3 = { 1 };

		int ret1 = t.solution(n1, lost1, reserve1);
		System.out.println("1 " + ret1);
		int ret2 = t.solution(n2, lost2, reserve2);
		System.out.println("2 " + ret2);
		int ret3 = t.solution(n3, lost3, reserve3);
		System.out.println("3 " + ret3);
	}

	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;

		int[] students = new int[n];

		Arrays.fill(students, 1);

		for (int r : reserve) {
			students[r - 1] += 1;
		}
		for (int l : lost) {
			students[l - 1] -= 1;
		}
		for (int i = 0; i < students.length; i++) {
			if (students[i] == 0) {
				if (i - 1 >= 0 && students[i - 1] == 2) {
					students[i - 1] = 1;
					students[i] = 1;
					continue;
				}
				if (i + 1 < students.length && students[i + 1] == 2) {
					students[i + 1] = 1;
					students[i] = 1;
					continue;
				}
			}

		}

		for (int s : students) {
			if (s != 0) {
				answer++;
			}
		}

		return answer;
	}

}
