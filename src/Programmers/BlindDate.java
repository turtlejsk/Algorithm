package Programmers;

import static org.junit.Assert.assertArrayEquals;

import java.util.LinkedList;
import java.util.Queue;

import org.junit.Test;

public class BlindDate {
	@Test
	public void test() {
		BlindDate bd = new BlindDate();

		int m1 = 3;
		int m2 = 4;
		int m3 = 5;

		int n1 = 3;
		int n2 = 6;
		int n3 = 5;

		int s1 = 150;
		int s2 = 25;
		int s3 = 12;

		int[][] time_map1 = { { 0, 2, 99 }, { 100, 100, 4 }, { 1, 2, 0 } };
		int[][] time_map2 = { { 0, 1, 1, -1, 2, 4 }, { -1, 7, 2, 1, 5, 7 }, { -1, 1, -1, 1, 6, 3 },
				{ -1, 1, -1, -1, 7, 0 } };
		int[][] time_map3 = { { 0, 1, 1, 1, 1 }, { 9, 9, 9, 1, 9 }, { 1, 1, 1, 1, 9 }, { 1, 1, 5, 9, 9 },
				{ 1, 1, 1, 1, 0 } };

		int[] ret1 = { 4, 103 };
		int[] ret2 = { 8, 15 };
		int[] ret3 = { 12, 11 };

		int[] answer1 = bd.solution(m1, n1, s1, time_map1);
		int[] answer2 = bd.solution(m2, n2, s2, time_map2);
		int[] answer3 = bd.solution(m3, n3, s3, time_map3);

		assertArrayEquals(ret1, answer1);
		assertArrayEquals(ret2, answer2);
		assertArrayEquals(ret3, answer3);
	}

	public int[] solution(int m, int n, int s, int[][] time_map) {
		int moveDistance = 0;
		int sumOfTalkTime = 0;

		int[][] visited = new int[m][n];
		int[][] dist = new int[m][n];
		int[] dx = { 1, -1, 0, 0 };
		int[] dy = { 0, 0, 1, -1 };

		Queue<Point> queue = new LinkedList<Point>();

		queue.offer(new Point(0, 0));

		while (!queue.isEmpty()) {
			Point p = queue.poll();

			if (p.x == n - 1 && p.y == m - 1) {
				moveDistance += dist[m - 1][n - 1];
				sumOfTalkTime += visited[m - 1][n - 1];
			}

			for (int i = 0; i < 4; i++) {
				if (p.x + dx[i] < 0 || p.x + dx[i] >= n || p.y + dy[i] < 0 || p.y + dy[i] >= m) {
					continue;
				}
				if (time_map[p.y + dy[i]][p.x + dx[i]] == -1) {
					continue;
				}
				if (visited[p.y][p.x] + time_map[p.y + dy[i]][p.x + dx[i]] >= s) {
					continue;
				}

				visited[p.y + dy[i]][p.x + dx[i]] = Math.min(visited[p.y + dy[i]][p.x + dx[i]],
						visited[p.y][p.x] + time_map[p.y + dy[i]][p.x + dx[i]]);
				dist[p.y + dy[i]][p.x + dx[i]] = Math.min(dist[p.y][p.x] + 1, dist[p.y + dy[i]][p.x + dx[i]]) ;
				// visited[p.y + dy[i]][p.x + dx[i]] = visited[p.y][p.x] + time_map[p.y +
				// dy[i]][p.x + dx[i]];
				queue.offer(new Point(p.y + dy[i], p.x + dx[i]));
			}
		}

		int[] answer = new int[2];
		answer[0] = moveDistance;
		answer[1] = sumOfTalkTime;

		return answer;
	}

	class Point {
		int y;
		int x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
