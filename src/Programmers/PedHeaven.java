package Programmers;

public class PedHeaven {

	public static void main(String[] args) {

		int m1 = 3;
		int n1 = 3;
		int[][] city_map1 = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

		int m2 = 3;
		int n2 = 6;
		int[][] city_map2 = { { 0, 2, 0, 0, 0, 2 }, { 0, 0, 2, 0, 1, 0 }, { 1, 0, 0, 2, 2, 0 } };

		PedHeaven ph = new PedHeaven();

		int ret1 = ph.solution(m1, n1, city_map1);
		System.out.println(ret1);
		System.out.println(ret1 % MOD == 6);

		int ret2 = ph.solution(m2, n2, city_map2);
		System.out.println(ret2);
		System.out.println(ret2 % MOD == 2);

	}

	static int MOD = 20170805;

	public int solution(int m, int n, int[][] cityMap) {
		int answer = 0;
		// 가로
		answer = find(0, 0, cityMap, 0);
		return answer;
	}

	public int find(int m, int n, int[][] cityMap, int dir) {
		int ret = 0;
		//System.out.println("m = " + m + ", n = " + n);
		if (m >= cityMap.length || n >= cityMap[0].length) {
			return 0;
		}
		if (m == cityMap.length - 1 && n == cityMap[0].length - 1) {
			return 1;
		} else if (cityMap[m][n] == 1) {
			return 0;
		} else if (cityMap[m][n] == 2) {
			if (dir == 0) {
				ret += find(m + 1, n, cityMap, 0);
			} else if (dir == 1) {
				ret += find(m, n + 1, cityMap, 1);
			}
		} else {
			ret += find(m + 1, n, cityMap, 0);
			ret += find(m, n + 1, cityMap, 1);
		}

		return ret;
	}
}
