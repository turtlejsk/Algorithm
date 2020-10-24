
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

	void delete(String word) {
		delete(this.rootNode, word, 0);
	}

	private void delete(TrieNode thisNode, String word, int index) {

		char character = word.charAt(index);

		if (!thisNode.getChildNodes().containsKey(character)) {
			throw new Error("There is no [" + word + "] in this Trie");
		}

		TrieNode childNode = thisNode.getChildNodes().get(character);
		index++;

		if (index == word.length()) {
			// 삭제조건 2번 항목
			// PO와 같이 노드는 존재하지만 insert한 단어가 아닌 경우 에러 출력

			if (!childNode.isLastChar()) {
				throw new Error("There is no [" + word + "] in this Trie");
			}

			childNode.setLastChar(false);
			// 삭제조건 1번 항목
			// 삭제 대상 언어의 제일 끝으로써 자식 노드가 없으면(이 단어를 포함하는 더 긴 단어가 없으면) 삭제 시작

			if (childNode.getChildNodes().isEmpty()) {
				thisNode.getChildNodes().remove(character);
			}
		} else {
			delete(childNode, word, index);

			// 삭제조건 1,3번 항목
			// 삭제 중, 자식 노드가 없고 현재 노드로 끝나는 다른 단어가 없는 경우 이 노드 삭제

			if (!childNode.isLastChar() && childNode.getChildNodes().isEmpty()) {
				thisNode.getChildNodes().remove(character);
			}
		}
	}

}
