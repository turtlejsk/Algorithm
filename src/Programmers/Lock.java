package Programmers;

import static org.junit.Assert.assertEquals;

import java.util.LinkedList;

import org.junit.Test;

public class Lock {

	// One shot One kill LOL
	@Test
	public void test() {
		int[][] key = { { 0, 0, 0 }, { 1, 0, 0 }, { 0, 1, 1 } };
		int[][] lock = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };

		Lock l = new Lock();
		boolean ret = l.solution(key, lock);

		assertEquals(true, ret);
	}

	public boolean solution(int[][] key, int[][] lock) {

		int m = key.length;
		int n = lock.length;

		int[][] key2 = rotate(key);
		int[][] key3 = rotate(key2);
		int[][] key4 = rotate(key3);

		LinkedList<int[][]> keyList = new LinkedList<>();
		keyList.add(key);
		keyList.add(key2);
		keyList.add(key3);
		keyList.add(key4);
		int cnt = 0;
		for (int i = 0; i < keyList.size(); i++) {
			int[][] tmpKey = keyList.get(i);

			for (int y = 1 - m; y < m + n - 1; y++) {
				for (int x = 1 - m; x < m + n - 1; x++) {
					boolean valid = true;
					for (int j = 0; j < n; j++) {
						for (int k = 0; k < n; k++) {
							cnt++;
							int check = 0;
							if (isSafe(j - y, k - x, m)) {
								check = lock[j][k] + tmpKey[j - y][k - x];
							} else {
								check = lock[j][k];
							}
							if (check != 1) {
								valid = false;
								break;
							}

						}
						if (!valid) {
							break;
						}
					}
					if (valid) {
						System.out.println(cnt);
						return true;
					}
				}
			}

		}

		return false;
	}

	public boolean isSafe(int y, int x, int m) {
		if (y < 0 || y >= m) {
			return false;
		}
		if (x < 0 || x >= m) {
			return false;
		}
		return true;
	}

	public int[][] rotate(int[][] key) {
		int[][] ret = new int[key.length][key.length];

		for (int i = 0; i < key.length; i++) {
			for (int j = 0; j < key.length; j++) {
				ret[i][j] = key[j][key.length - i - 1];
			}
		}
		return ret;
	}
}
