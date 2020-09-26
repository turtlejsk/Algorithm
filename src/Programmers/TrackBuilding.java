package Programmers;

public class TrackBuilding {
	public static void main(String[] args) {
		int n1 = 7;
		int[] p1 = { 6, 2, 1, 0, 2, 4, 3 };
		int[] c1 = { 3, 6, 6, 2, 3, 7, 6 };

		TrackBuilding tb = new TrackBuilding();
		tb.solution(n1, p1, c1);
	}

	public String solution(int n, int[] p, int[] c) {
		String answer = "";

		int price = 100;
		int income = 0;
		int[] newP = new int[n + 1];

		for (int i = 0; i < p.length; i++) {
			newP[i] = p[i];
		}

		newP[n] = 0;
		int rest[] = new int[n + 1];
		rest[n] = 0;

		int failCount = 0;
		for (int i = 0; i < n; i++) {
			if (failCount == 3) {
				income /= i;
				break;
			}
			rest[i + 1] = newP[i] - c[i];
			if (rest[i + 1] < 0) {
				newP[i + 1] += newP[i];
				price /= 2;
				failCount++;
				if (price < 25) {
					price = 25;
				}
			} else {
				System.out.println("made moeny");
				System.out.println("c[" + i + "] = " + c[i]);
				System.out.println("price : " + price);
				income = income + c[i] * price;
				newP[i + 1] += rest[i + 1];
				price = 100;
				failCount = 0;
			}
		}

		System.out.println(income);
		return answer;
	}

}
