package Programmers;

public class Robbery {
	public static void main(String[] args) {
		Robbery r = new Robbery();
		int[] money = { 1, 2, 3, 1 };
		int ret = r.solution(money);
		System.out.println(ret);
	}

	public int solution(int[] money) {
		int answer = 0;
		int length = money.length;
		int[] cache = new int[length];
		int ret[] = new int[length];
		for (int i = 0; i < length; i++) {
			cache[0] = money[i];
			cache[1] = money[i] < money[(i + 1) % length] ? money[(i + 1) % length] : money[i];
			for (int j = 2; j < money.length; j++) {
		
				cache[j] = Math.max(cache[j - 1], cache[j - 2] + money[(i + j) % length]);
			}

			ret[i] = cache[length - 1];
		}

		for (int i = 0; i < ret.length; i++) {
			System.out.println(ret[i]);
			if (ret[i] > answer) {
				answer = ret[i];
			}
		}
		return answer;
	}
}
