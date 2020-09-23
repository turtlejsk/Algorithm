package test;

import java.util.*;

public class TransWord {
	public static void main(String[] args) {
		String begin = "fit";
		String target = "hit";
		String[] words = { "hot", "dot", "dog", "lot", "log", "cog" };

		String begin2 = "hit";
		String target2 = "dot";
		String[] words2 = { "hot", "dot", "fds", "fot", "aaa", "hip" };

		String begin3 = "hit";
		String target3 = "hot";
		String[] words3 = { "hot", "dot", "fds", "fot", "aaa", "hip" };

		String begin4 = "hit";
		String target4 = "hhh";
		String[] words4 = { "hhh", "hht" };

		System.out.println("answer:" + solution(begin3, target3, words3));
	}

	public static int solution(String begin, String target, String[] words) {
		int answer = words.length;

		// words 배열 내에서 target은 몇번째에 있나
		int targetIdx = 0;
		// words 배열 내에 target이 없을경우 체크용
		boolean check = false;

		// target의 index 찾기
		for (String word : words) {
			if (word.equals(target)) {
				check = true;
				break;
			}
			targetIdx++;
		}
		// words 안에 target이 없으므로 0 반환
		if (check == false) {
			return 0;
		}

		// begin과 target이 바로 변환 가능할 경우 1 반환
		if (canSwap(begin, target)) {
			return 1;
		}

		// 답 저장용
		ArrayList<Integer> answerList = new ArrayList<>();

		// begin과 words를 합친 배열을 만든다.
		String[] map = new String[words.length + 1];
		targetIdx++;
		int mapLength = map.length;

		// map 배열 초기화
		map[0] = begin;
		for (int i = 1; i < mapLength; i++) {
			map[i] = words[i - 1];
		}

		// 그래프 작성 canSwap이면 1(연결)
		int[][] graph = new int[mapLength][mapLength];

		for (int i = 0; i < mapLength; i++) {
			for (int j = 0; j < mapLength; j++) {
				if (canSwap(map[i], map[j])) {
					graph[i][j] = 1;
					graph[j][i] = 1;
				}
			}
		}

		int[] visited = new int[mapLength];
		for (int v : visited) {
			v = 0;
		}
		// 0(begin)에서 target의 인덱스까지 dfs
		dfs(graph, visited, 0, targetIdx, 0, answerList);

		for (int min : answerList) {
			if (answer > min) {
				answer = min;
			}
		}
		return answer;
	}

	public static void dfs(int[][] graph, int[] visited, int from, int to, int change, ArrayList<Integer> answerList) {
		visited[from] = 1;
		if (from == to) {
			answerList.add(change);
		} else {
			for (int i = 0; i < graph.length; i++) {
				if (graph[from][i] == 1 && visited[i] == 0) {

					change += 1;
					dfs(graph, visited, i, to, change, answerList);
				}
			}
		}
	}

	public static boolean canSwap(String from, String to) {
		boolean ret = false;
		char[] fromChar = from.toCharArray();
		char[] toChar = to.toCharArray();

		int cnt = 0;
		for (int i = 0; i < fromChar.length; i++) {
			if (fromChar[i] == toChar[i]) {
				cnt++;
			}
		}

		if (cnt == from.length() - 1) {

			ret = true;
		}
		return ret;
	}

}
