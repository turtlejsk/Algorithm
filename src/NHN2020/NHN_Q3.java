package NHN2020;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class NHN_Q3 {
	@Test
	public void test() {

		NHN_Q3 n3 = new NHN_Q3();
		int numOfAllPlayers1 = 6;
		int numOfQuickPlayers1 = 2;
		char[] namesOfQuickPlayers1 = { 'B', 'C' };
		int numOfGames1 = 2;
		int[] numOfMovesPerGame1 = { 3, -2 };
		n3.solution(numOfAllPlayers1, numOfQuickPlayers1, namesOfQuickPlayers1, numOfGames1, numOfMovesPerGame1);

		int numOfAllPlayers2 = 17;
		int numOfQuickPlayers2 = 5;
		char[] namesOfQuickPlayers2 = { 'B', 'D', 'I', 'M', 'P' };
		int numOfGames2 = 11;
		int[] numOfMovesPerGame2 = { 3, -4, 5, 6, -7, -8, 10, -12, -15, -20, 23 };

		n3.solution(numOfAllPlayers2, numOfQuickPlayers2, namesOfQuickPlayers2, numOfGames2, numOfMovesPerGame2);

	}

	private void solution(int numOfAllPlayers, int numOfQuickPlayers, char[] namesOfQuickPlayers, int numOfGames,
			int[] numOfMovesPerGame) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.

		int[] sullae = new int[numOfAllPlayers];
		int[] fast = new int[numOfAllPlayers];
		char[] sit = new char[numOfAllPlayers - 1];
		int sitLen = numOfAllPlayers - 1;
		Arrays.fill(sullae, 0);
		Arrays.fill(fast, 0);

		for (int i = 0; i < sit.length; i++) {
			sit[i] = (char) (66 + i);
		}

		sullae[0] = 1;
		for (char n : namesOfQuickPlayers) {
			fast[n - 65] = 1;
		}

		for (int i = 0; i < numOfMovesPerGame.length; i++) {
			if (numOfMovesPerGame[i] < 0) {
				numOfMovesPerGame[i] = numOfAllPlayers + numOfMovesPerGame[i] - 1;
			}
		}
		int pointer = 0;
		char prev = 'A';
		for (int i = 0; i < numOfGames; i++) {
			pointer = pointer + numOfMovesPerGame[i];
			char next = sit[pointer % sitLen];
			if (fast[next - 65] == 1) {
				sullae[prev - 65] += 1;
			} else {
				char tmp = next;

				sullae[next - 65] += 1;
				sit[pointer % sitLen] = prev;
				prev = tmp;

			}
		}

		for (int i = 0; i < sit.length; i++) {
			char name = sit[i];
			int count = sullae[name - 65];
			System.out.println(name + " " + count);
		}
		System.out.println(prev + " " + sullae[prev - 65]);

	}

}
