package Programmers;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class CampingTest {

	@Test
	public void testCamp() {
		String[] lines = { "2016-09-15 00:00:00.000 3s" };

		String[] lines2 = { "2016-09-15 20:59:57.421 0.351s", "2016-09-15 20:59:58.233 1.181s",
				"2016-09-15 20:59:58.299 0.8s", "2016-09-15 20:59:58.688 1.041s", "2016-09-15 20:59:59.591 1.412s",
				"2016-09-15 21:00:00.464 1.466s", "2016-09-15 21:00:00.741 1.581s", "2016-09-15 21:00:00.748 2.31s",
				"2016-09-15 21:00:00.966 0.381s", "2016-09-15 21:00:02.066 2.62s" };

		String[] lines3 = { "2016-09-15 00:00:00.000 2.3s", "2016-09-15 23:59:59.999 0.1s" };

		Choosuk c = new Choosuk();

		int answer1 = c.solution(lines);
		assertEquals(1, answer1);

		int answer2 = c.solution(lines2);
		assertEquals(7, answer2);

		int answer3 = c.solution(lines3);
		assertEquals(1, answer3);

	}

}
