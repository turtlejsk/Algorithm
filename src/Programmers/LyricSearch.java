package Programmers;

import static org.junit.Assert.assertArrayEquals;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

import org.junit.Test;

public class LyricSearch {

	@Test
	public void test() {
		LyricSearch ls = new LyricSearch();
		String[] words = { "frodo", "front", "frost", "frozen", "frame", "kakao" };
		String[] queries = { "fro??", "????o", "fr???", "fro???", "pro?" };

		int[] results = { 3, 2, 4, 1, 0 };

		int[] ret = ls.solution(words, queries);

		assertArrayEquals(results, ret);
	}

	public int[] solution(String[] words, String[] queries) {
		int[] answer = new int[queries.length];

		Trie t = new Trie();
		for (String w : words) {
			t.insert(w);
		}

		Trie tRev = new Trie();
		for (String w : words) {
			tRev.insert(reverse(w));
		}

		for (int i = 0; i < queries.length; i++) {
			String query = queries[i];
			if (query.charAt(0) == '?') {
				String filtered = query.replace("?", "");
				answer[i] = tRev.countChild(reverse(filtered));
			} else {
				

				String filtered = query.replace("?", "");
				answer[i] = t.countChild(filtered);
			}

		}
		return answer;
	}

	public String reverse(String s) {
		char[] wChar = s.toCharArray();
		char[] tmp = new char[wChar.length];
		for (int i = 0; i < wChar.length; i++) {
			tmp[i] = wChar[wChar.length - i - 1];
		}
		return String.valueOf(tmp);
	}

	public class Trie {
		private TrieNode rootNode;

		Trie() {
			rootNode = new TrieNode();
		}

		void insert(String word) {
			TrieNode thisNode = this.rootNode;

			for (int i = 0; i < word.length(); i++) {
				thisNode = thisNode.getChildNodes().computeIfAbsent(word.charAt(i), c -> new TrieNode());

			}

			thisNode.setLastChar(true);
		}

		boolean contains(String word) {
			TrieNode thisNode = this.rootNode;

			for (int i = 0; i < word.length(); i++) {
				char character = word.charAt(i);

				TrieNode node = thisNode.getChildNodes().get(character);

				if (node == null) {
					return false;
				}
				thisNode = node;

			}

			return thisNode.isLastChar();
		}

		int countChild(String word) {
			int count = 0;

			TrieNode thisNode = this.rootNode;
			
			Queue<TrieNode> q = new LinkedList<>();

			for (int i = 0; i < word.length(); i++) {
				char character = word.charAt(i);
				TrieNode node = thisNode.getChildNodes().get(character);
				
				
				if (node == null) {
					return 0;
				}
				thisNode = node;

			}

			if (thisNode.isLastChar) {
				return 1;
			} else {
				q.offer(thisNode);
				while (!q.isEmpty()) {

					TrieNode tmpNode = q.poll();
					if (tmpNode.isLastChar) {
						count++;
						
					} else {
						for (Entry<Character, TrieNode> n : tmpNode.getChildNodes().entrySet()) {
							q.add(n.getValue());
						}
						
					}
				}

				return count;
			}

		}

	}

	public class TrieNode {

		private Map<Character, TrieNode> childNodes = new HashMap<>();

		private boolean isLastChar;

		public Map<Character, TrieNode> getChildNodes() {
			return childNodes;
		}

		public void setChildNodes(Map<Character, TrieNode> childNodes) {
			this.childNodes = childNodes;
		}

		public boolean isLastChar() {
			return isLastChar;
		}

		public void setLastChar(boolean isLastChar) {
			this.isLastChar = isLastChar;
		}

	}
}
