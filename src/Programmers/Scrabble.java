package Programmers;


import java.util.HashSet;

public class Scrabble {
	public static void main(String[] args) {
		int n1 = 3;
		String[] words1 = { "tank", "kick", "know", "wheel", "land", "dream", "mother", "robot", "tank" };
		int[] answer1 = { 3, 3 };

		int n2 = 5;
		String[] words2 = { "hello", "observe", "effect", "take", "either", "recognize", "encourage", "ensure",
				"establish", "hang", "gather", "refer", "reference", "estimate", "executive" };
		int[] answer2 = { 0, 0 };

		int n3 = 2;
		String[] words3 = { "hello", "one", "even", "never", "now", "world", "draw" };
		int[] answer3 = { 1, 3 };

		Scrabble sc = new Scrabble();

		int[] ret1 = sc.solution(n1, words1);
		System.out.println("(" + ret1[0] + ", " + ret1[1] + ")");
		int[] ret2 = sc.solution(n2, words2);
		System.out.println("(" + ret2[0] + ", " + ret2[1] + ")");
		int[] ret3 = sc.solution(n3, words3);
		System.out.println("(" + ret3[0] + ", " + ret3[1] + ")");
	}

	public int[] solution(int n, String[] words) {

		HashSet<String> hs = new HashSet();

		int wrong = 0;
		hs.add(words[0]);

		for (int i = 1; i < words.length; i++) {
			String prev = words[i - 1];
			String cur = words[i];

			if (prev.charAt(prev.length() - 1) != cur.charAt(0)) {
				wrong = i;
				System.out.println("끝말잇기 틀림! wrong = " + wrong);
				break;
			}

			if (hs.contains(cur)) {
				wrong = i;
				System.out.println("중복! wrong = " + wrong);
				break;
			}

			hs.add(cur);

		}

		int[] answer = { (wrong) % n + 1, (wrong) / n + 1 };

		return answer;
	}
}
