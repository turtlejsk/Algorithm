package Programmers;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Choosuk {
	public static void main(String[] args) {

		String[] lines = { "2016-09-15 00:00:00.000 3s" };

		String[] lines2 = { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };

		String[] lines3 = { "2016-09-15 00:00:00.000 2.3s", "2016-09-15 23:59:59.999 0.1s" };

		Choosuk c = new Choosuk();

		int answer1 = c.solution(lines);
		System.out.print("answer1 = " + answer1 + ", ");
		System.out.println(answer1 == 1);

		int answer2 = c.solution(lines2);
		System.out.print("answer2 = " + answer2 + ", ");
		System.out.println(answer2 == 7);

		int answer3 = c.solution(lines3);
		System.out.print("answer3 = " + answer3 + ", ");
		System.out.println(answer3 == 1);

	}

	public int solution(String[] lines) {
		int answer = 0;

		long[] start = new long[lines.length];
		long[] durations = new long[lines.length];

		int taskNum = 0;
		SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss.SSS");
		try {

			for (String line : lines) {

				String[] blankTok = line.split(" ");
				String finish = blankTok[1];
				String duration = blankTok[2];

				duration = duration.substring(0, duration.length() - 1);

				if (duration.contains(".")) {
					duration = duration.replace(".", "");
				}

				int temp = duration.length();

				for (int i = temp; i < 4; i++) {
					duration = duration.concat("0");
				}

				long d = Long.parseLong(duration);

				Date endTime = format.parse(finish);
				Long st = endTime.getTime() - d + 1;

				start[taskNum] = st;
				durations[taskNum] = d - 1;

				taskNum++;
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		long[] normStart = new long[start.length];

		long min = 1000000000000000L;
		for (long l : start) {
			if (l < min) {
				min = l;
			}
		}

		for (int i = 0; i < start.length; i++) {
			long norm = start[i] - min;
			normStart[i] = norm;
		}

		int active[] = new int[normStart.length];

		for (int i = 0; i < normStart.length; i++) {
			int count = 0;
			long taskEnd = normStart[i] + durations[i];
			for (int j = 0; j < normStart.length; j++) {
				if (taskEnd <= normStart[j] + durations[j] && taskEnd + 999 >= normStart[j] + durations[j]) {
					count++;
				} else if (taskEnd + 999 >= normStart[j] && taskEnd <= normStart[j]) {
					count++;
				} else if (taskEnd >= normStart[j] && taskEnd + 999 <= normStart[j] + durations[j]) {
					count++;
				} else if (taskEnd + 999 >= normStart[j] + durations[j] && taskEnd <= normStart[j]) {
					count--;
				}
			}
			active[i] = count;
		}

		for (int t : active) {
			if (t > answer) {
				answer = t;
			}
		}
		return answer;
	}
}
