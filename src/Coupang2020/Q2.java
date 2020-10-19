package Coupang2020;

import java.util.PriorityQueue;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;

public class Q2 {
	public static void main(String[] args) {
		Q2 q2 = new Q2();

		int n1 = 3;
		int n2 = 2;

		String[] customers1 = { "10/01 23:20:25 30", "10/01 23:25:50 26", "10/01 23:31:00 05", "10/01 23:33:17 24",
				"10/01 23:50:25 13", "10/01 23:55:45 20", "10/01 23:59:39 03", "10/02 00:10:00 10" };
		String[] customers2 = { "02/28 23:59:00 03", "03/01 00:00:00 02", "03/01 00:05:00 01" };

		int answer1 = 4;
		int answer2 = 2;

		int ret1 = q2.solution(n1, customers1);

		System.out.println(ret1);
		System.out.println(ret1 == answer1);
		int ret2 = q2.solution(n2, customers2);

		System.out.println(ret2);
		System.out.println(ret2 == answer2);
	}

	public int solution(int n, String[] customers) {
		int answer = 0;

		PriorityQueue<Task> pq = new PriorityQueue<>();
		PriorityQueue<Task> waitingQ = new PriorityQueue<>();
		PriorityQueue<Kiosk> kioskQ = new PriorityQueue<>();

		for (int i = 0; i < n; i++) {
			kioskQ.offer(new Kiosk(i, i));
		}
		SimpleDateFormat sdf = new SimpleDateFormat("MM/dd.hh:mm:ss");
		try {
			long min = Long.MAX_VALUE;
			for (int i = 0; i < customers.length; i++) {
				String[] tokens = customers[i].split(" ");
				String MonthDate = tokens[0];
				String HMS = tokens[1];
				String duration = tokens[2];

				Date date = sdf.parse(MonthDate + "." + HMS);
				if (i == 0) {
					min = date.getTime();
				}
				long durationLong = Long.parseLong(duration) * 60000;
				long startTime = date.getTime() - min;
				long endTime = startTime + durationLong;

				pq.offer(new Task(startTime, false, i));
				pq.offer(new Task(endTime, true, i));

			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		int[] kioskArr = new int[n];
		boolean[] kioskAvail = new boolean[n];

		Arrays.fill(kioskArr, 0);
		Arrays.fill(kioskAvail, true);

		HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();

		while (!pq.isEmpty()) {
			Task task = pq.poll();

			if (task.done == false) {
				// System.out.println("taskID = " + task.taskID);

				if (!kioskQ.isEmpty()) {
					Kiosk targetK = kioskQ.poll();
					int kNum = targetK.kioskID;
					kioskAvail[kNum] = false;
					kioskArr[kNum] += 1;
					hm.put(task.taskID, kNum);
					// i는 키오스크 번호
				} else {
					waitingQ.offer(task);
				}

			} else {
				// System.out.println("taskID = " + task.taskID + " is Done");

				int kioskNum = hm.get(task.taskID);
				if (!waitingQ.isEmpty()) {
					Task wait = waitingQ.poll();
					hm.put(wait.taskID, kioskNum);

					kioskArr[kioskNum] += 1;
				} else {
					kioskQ.add(new Kiosk(kioskNum, task.time));
					kioskAvail[kioskNum] = true;

				}
			}
		}

		for (int k : kioskArr) {
			if (k >= answer) {
				answer = k;
			}
		}

		return answer;
	}

	public class Task implements Comparable<Task> {
		boolean done;
		long time;
		int taskID;

		public Task(long time, boolean done, int taskID) {
			this.time = time;
			this.done = done;
			this.taskID = taskID;
		}

		@Override
		public int compareTo(Task o) {
			// TODO Auto-generated method stub
			if (this.time > o.time) {
				return 1;
			} else if (this.time < o.time) {
				return -1;
			}
			return 0;
		}

	}

	public class Kiosk implements Comparable<Kiosk> {
		int kioskID;
		long time;

		public Kiosk(int kioskID, long time) {
			this.kioskID = kioskID;
			this.time = time;
		}

		@Override
		public int compareTo(Kiosk o) {
			// TODO Auto-generated method stub
			if(this.time > o.time) {
				return 1;
			}else if (this.time <o.time) {
				return -1;
			}
			return 0;
		}
	}

}
