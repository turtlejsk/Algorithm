package Programmers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class Landscape {

	@Test
	public void test() {
		int[][] land1 = { { 1, 4, 8, 10 }, { 5, 5, 5, 5 }, { 10, 10, 10, 10 }, { 10, 10, 10, 20 } };
		int[][] land2 = { { 10, 11, 10, 11 }, { 2, 21, 20, 10 }, { 1, 20, 21, 11 }, { 2, 1, 2, 1 } };

		int height1 = 3;
		int height2 = 1;

		int result1 = 15;
		int result2 = 18;

		Landscape l = new Landscape();

		int answer1 = l.solution(land1, height1);
		int answer2 = l.solution(land2, height2);

		assertEquals(result1, answer1);
		assertEquals(result2, answer2);
	}

	public int solution(int[][] land, int height) {
		int answer = 0;
		int size = land.length;
		int[][] visited = new int[size][size];
		for (int[] a : visited) {
			Arrays.fill(a, -1);
		}

		int comp = 0;

		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (visited[i][j] >= 0)
					continue;

				Queue<Pair> q = new LinkedList<>();
				q.offer(new Pair(i, j));
				visited[i][j] = comp;

				while (!q.isEmpty()) {
					int x = q.peek().x;
					int y = q.peek().y;
					q.poll();

					for (int k = 0; k < 4; k++) {
						int newX = x + dirX[k];
						int newY = y + dirY[k];
 
						if (newX < 0 || newX >= size || newY < 0 || newY >= size)
							continue;
						if (visited[newX][newY] >= 0)
							continue;
						if (Math.abs(land[x][y] - land[newX][newY]) > height)
							continue;

						visited[newX][newY] = comp;
						q.offer(new Pair(newX, newY));
					}
				}
				comp++;
			}
		}

		// visited 배열의 component 정보를 이용해서 Edge 배열 e 구하기
		ArrayList<Edge> e = new ArrayList<>();

		for (int x = 0; x < size; x++) {
			for (int y = 0; y < size; y++) {
				for (int i = 0; i < 4; i++) {
					int newX = x + dirX[i];
					int newY = y + dirY[i];

					if (newX < 0 || newX >= size || newY < 0 || newY >= size)
						continue;
					if (visited[x][y] == visited[newX][newY])
						continue;

					int comp1 = visited[x][y];
					int comp2 = visited[newX][newY];

					int p = Math.abs(land[x][y] - land[newX][newY]);
					e.add(new Edge(comp1, comp2, p));
				}
			}
		}

		if (e.size() == 0)
			return 0;

		// MST(크루스칼)
		uf = new int[comp];
		Arrays.fill(uf, -1);

		Collections.sort(e, new Comparator<Edge>() {
			@Override
			public int compare(Edge o1, Edge o2) {
				return Integer.compare(o1.w, o2.w);
			}
		});

		int cnt = 0;
		for (int i = 0;; i++) {
			if (merge(e.get(i).u, e.get(i).v)) {
				answer += e.get(i).w;
				if (++cnt == comp - 1)
					break;
			}
		}

		return answer;
	}

	class Pair {
		int x;
		int y;

		public Pair(int x, int y) {
			this.x = x;
			this.y = y;
		}
	}

	class Edge {
		int u, v, w;

		public Edge(int u, int v, int w) {
			this.u = u;
			this.v = v;
			this.w = w;
		}
	}

	int[] dirX = new int[] { 0, 0, 1, -1 };
	int[] dirY = new int[] { 1, -1, 0, 0 };

	int[] uf;

	int find(int a) {
		if (uf[a] < 0)
			return a;
		return uf[a] = find(uf[a]);
	}

	boolean merge(int a, int b) {
		a = find(a);
		b = find(b);
		if (a == b)
			return false;
		uf[b] = a;
		return true;
	}

}
