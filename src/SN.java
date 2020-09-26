
public class SN {
	public static void main(String[] args) {
		SN sn = new SN();
		long answer = sn.solution(6);
		System.out.println(answer);
	}

	public long solution(int k) {
		long answer = 0;
		int len = k;
		if (k < 10) {
			len = 10;
		}
		int[] map = new int[len];
		// map[k]는 k개로 만들수있는 숫자의 가지수

		for (int i = 0; i < map.length; i++) {
			map[i] = -1;
		}

		map[2] = 1;
		map[3] = 2;
		map[5] = 3;
		map[6] = 2;
		map[7] = 1;

		
		find(k, map);
		
		int i = k;
		while(k >= 6) {
			map[k] -= map[k-6];
			k-=6;
		}
		
		return answer;
	}

	public long find(int k, int[] map) {
		if (k < 0) {
			return 0;
		}
		if (map[k] != -1) {
			return map[k];
		} else {
			return find(k - 2, map) + find(k - 3, map) + find(k - 4, map) + 3 * find(k - 5, map) + 2 * find(k - 6, map)
					+ find(k - 7, map);
		}
	}
}
