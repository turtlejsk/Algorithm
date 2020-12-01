package Programmers;

import static org.junit.Assert.assertArrayEquals;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class FuncDev {
	@Test
	public void test() {
		int[] progresses1 = { 93, 30, 55 };
		int[] progresses2 = { 95, 90, 99, 99, 80, 99 };

		int[] speeds1 = { 1, 30, 5 };
		int[] speeds2 = { 1, 1, 1, 1, 1, 1 };

		int[] ret1 = { 2, 1 };
		int[] ret2 = { 1, 3, 2 };

		FuncDev fd = new FuncDev();

		int[] answer1 = fd.solution(progresses1, speeds1);
		int[] answer2 = fd.solution(progresses2, speeds2);

		assertArrayEquals(ret1, answer1);
		assertArrayEquals(ret2, answer2);
	}

	public int[] solution(int[] progresses, int[] speeds) {

		int length = progresses.length;

		ArrayList<Integer> arr = new ArrayList<>();

		Queue<Integer> q = new LinkedList<>();

		for (int i = 0; i < length; i++) {
			int days = (int) Math.ceil(((double) (100 - progresses[i]) / speeds[i]));
			q.offer(days);
		}

		while (!q.isEmpty()) {
			int cnt = 0;
			int p = q.poll();
			cnt++;

			while (!q.isEmpty() && q.peek() <= p) {
				q.poll();
				cnt++;
			}
			arr.add(cnt);
		}

		int[] answer = new int[arr.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = arr.get(i);
		}

		return answer;
	}
}
