package Programmers;

import java.util.Iterator;
import java.util.PriorityQueue;

public class Camping {
	public static void main(String[] args) {

		int n = 4;
		int[][] data = { { 0, 0 }, { 1, 1 }, { 0, 2 }, { 2, 0 } };

		int answer = 3;

		Camping c = new Camping();

		int ret = c.solution(n, data);
		System.out.println(ret);
		System.out.println(ret == answer);
	}

	public int solution(int n, int[][] data) {
		int answer = 0;
		PriorityQueue<Pick> pq = new PriorityQueue<>();
		for (int[] a : data) {
			pq.offer(new Pick(a[0], a[1]));
		}

		
		return answer;
	}

	public class Pick implements Comparable<Pick> {

		int y;
		int x;

		public Pick(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(Pick o) {
			if (this.y < o.y) {
				return -1;
			} else if (this.y > o.y) {
				return 1;
			} else {
				if (this.x < o.x) {
					return -1;
				} else {
					return 1;
				}
			}
		}
	}
}
