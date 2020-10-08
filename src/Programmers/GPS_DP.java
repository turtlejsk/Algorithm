package Programmers;



public class GPS_DP {
	public static void main(String[] args) {
		int n1 = 7;
		int m1 = 10;
		int[][] edge_list1 = { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 }, { 4, 6 }, { 5, 6 }, { 5, 7 },
				{ 6, 7 } };
		int k1 = 6;
		int[] gps_log1 = { 1, 2, 3, 3, 6, 7 };
		int answer1 = 1;

		int n2 = 7;
		int m2 = 10;
		int[][] edge_list2 = { { 1, 2 }, { 1, 3 }, { 2, 3 }, { 2, 4 }, { 3, 4 }, { 3, 5 }, { 4, 6 }, { 5, 6 }, { 5, 7 },
				{ 6, 7 } };
		int k2 = 6;
		int[] gps_log2 = { 1, 2, 4, 6, 5, 7 };
		int answer2 = 0;

		GPS_DP gps = new GPS_DP();
		int ret1 = gps.solution(n1, m1, edge_list1, k1, gps_log1);
		System.out.println(ret1);
		System.out.println(ret1 == answer1);

		int ret2 = gps.solution(n2, m2, edge_list2, k2, gps_log2);
		System.out.println(ret2);
		System.out.println(ret2 == answer2);
	}

	public int solution(int n, int m, int[][] edge_list, int k, int[] gps_log) {
		int answer = 0;

		

		
		

		return answer;
	}

}
