package Programmers;

import java.util.Arrays;
import java.util.LinkedList;

public class ShuttleBus {
	public static void main(String[] args) {

		int n1 = 1;
		int t1 = 1;
		int m1 = 5;
		String[] timetable1 = { "08:00", "08:01", "08:02", "08:03" };

		int n2 = 2;
		int t2 = 10;
		int m2 = 2;
		String[] timetable2 = { "09:10", "09:09", "08:00" };

		int n3 = 2;
		int t3 = 1;
		int m3 = 2;
		String[] timetable3 = { "09:00", "09:00", "09:00", "09:00" };

		int n4 = 1;
		int t4 = 1;
		int m4 = 5;
		String[] timetable4 = { "00:01", "00:01", "00:01", "00:01", "00:01" };

		int n5 = 1;
		int t5 = 1;
		int m5 = 1;
		String[] timetable5 = { "23:59" };

		int n6 = 10;
		int t6 = 60;
		int m6 = 45;
		String[] timetable6 = { "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59",
				"23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59" };

		ShuttleBus sb = new ShuttleBus();

		String answer1 = sb.solution(n1, t1, m1, timetable1);

		System.out.println("answer1 : " + answer1 + ", " + answer1.equals("09:00"));
		String answer2 = sb.solution(n2, t2, m2, timetable2);
		System.out.println("answer2 : " + answer2 + ", " + answer2.equals("09:09"));
		String answer3 = sb.solution(n3, t3, m3, timetable3);
		System.out.println("answer3 : " + answer3 + ", " + answer3.equals("08:59"));
		String answer4 = sb.solution(n4, t4, m4, timetable4);
		System.out.println("answer4 : " + answer4 + ", " + answer4.equals("00:00"));
		String answer5 = sb.solution(n5, t5, m5, timetable5);
		System.out.println("answer5 : " + answer5 + ", " + answer5.equals("09:00"));
		String answer6 = sb.solution(n6, t6, m6, timetable6);
		System.out.println("answer6 : " + answer6 + ", " + answer6.equals("18:00"));
	}

	public String solution(int n, int t, int m, String[] timetable) {
		String answer = "";

		// 09:00 부터
		// t분 간격으로 0-60
		// n회 운영 0-10
		// m명 탑승가능 0-45
		// timetable - 크루의 도착시간

		int[] timetableI = new int[timetable.length];
		int firstBus = 540;
		for (int i = 0; i < timetable.length; i++) {
			String stringTime = timetable[i];
			String regex = "[:]";
			String[] timeTokens = stringTime.split(regex);

			String hr = timeTokens[0];
			String min = timeTokens[1];

			int time = Integer.parseInt(hr) * 60 + Integer.parseInt(min);

			timetableI[i] = time;
		}
		Arrays.sort(timetableI);

		LinkedList<Integer>[] busList = new LinkedList[n];

		for (int i = 0; i < busList.length; i++) {
			busList[i] = new LinkedList<Integer>();
		}

		for (int i = 0; i < timetableI.length; i++) {
			for (int j = 0; j < busList.length; j++) {
				if (timetableI[i] <= firstBus + t * j && busList[j].size() < m) {
					busList[j].add(timetableI[i]);
					break;
				}
			}
		}

		int validBusNum = -1;
		// 탈수있는버스가 있는지 검사

		for (int i = busList.length; i > 0; i--) {
			if (busList[i - 1].size() < m) {
				validBusNum = i - 1;
				break;
			}
		}
		int lastTime = 0;
		if (validBusNum == -1) {
			LinkedList<Integer> lastBus = busList[busList.length - 1];
			lastTime = lastBus.get(lastBus.size() - 1) - 1;
		} else {

			LinkedList<Integer> lastBus = busList[busList.length - 1];
			int min = 0;
			if (lastBus.size() != 0) {
				min = Math.max(lastBus.get(lastBus.size() - 1) - 1, firstBus + t * validBusNum);
			} else {
				min = firstBus + t * validBusNum;
			}

			lastTime = min;
		}

		int lasthr = lastTime / 60;
		int lastmin = lastTime % 60;
		String hr = "";
		String min = "";
		if (lasthr < 10) {
			hr = hr.concat("0").concat(String.valueOf(lasthr));
		} else if (lasthr == 0) {
			hr = "00";
		} else {
			hr = hr.concat(String.valueOf(lasthr));
		}
		if (lastmin < 10) {
			min = min.concat("0").concat(String.valueOf(lastmin));
		} else if (lastmin == 0) {
			min = "00";
		} else {
			min = min.concat(String.valueOf(lastmin));
		}

		answer = answer.concat(hr + ":");
		answer = answer.concat(min);

		return answer;
	}

}
