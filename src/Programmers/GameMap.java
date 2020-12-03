package Programmers;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class GameMap {

	@Test
	public void test() {
		int[][] maps1 = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 1 },
				{ 0, 0, 0, 0, 1 } };
		int[][] maps2 = { { 1, 0, 1, 1, 1 }, { 1, 0, 1, 0, 1 }, { 1, 0, 1, 1, 1 }, { 1, 1, 1, 0, 0 },
				{ 0, 0, 0, 0, 1 } };

		GameMap gm = new GameMap();
		int answer1 = gm.solution(maps1);
		int answer2 = gm.solution(maps2);

		assertEquals(11, answer1);
		assertEquals(-1, answer2);

	}

	public int solution(int[][] maps) {
		int answer = 0;

		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		int yLength = maps.length;
		int xLength = maps[0].length;

		int[][] visited = new int[yLength][xLength];
		for (int[] v : visited) {
			Arrays.fill(v, 0);
		}

		Queue<Point> queue = new LinkedList<>();

		Point start = new Point(0, 0);
		queue.offer(start);
		visited[0][0] = 1;

		ArrayList<Integer> arr = new ArrayList<>();

		while (!queue.isEmpty()) {
			Point tmp = queue.poll();
			
			if (tmp.y == yLength - 1 && tmp.x == xLength - 1) {
				arr.add(tmp.dist);
			}

			for (int i = 0; i < 4; i++) {
				if (tmp.x + dx[i] < 0 || tmp.y + dy[i] < 0 || tmp.x + dx[i] >= xLength || tmp.y + dy[i] >= yLength) {
					continue;
				}
				if (visited[tmp.y + dy[i]][tmp.x + dx[i]] > 1 || maps[tmp.y + dy[i]][tmp.x + dx[i]] == 0) {
					continue;
				}
				queue.offer(new Point(tmp.y + dy[i], tmp.x + dx[i]));
				visited[tmp.y + dy[i]][tmp.x + dx[i]] = visited[tmp.y][tmp.x] + 1;
			}

		}

		if(visited[yLength - 1][xLength - 1] == 0) {
			answer = -1;
		}else {
			answer = visited[yLength - 1][xLength - 1];
		}

		return answer;
	}

	class Point {
		int x;
		int y;
		int dist;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
			this.dist = 1;
		}

		public Point(int y, int x, int dist) {
			this(y, x);
			this.dist = dist;
		}
	}
}
