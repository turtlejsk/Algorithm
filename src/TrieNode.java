import java.util.HashMap;
import java.util.Map;

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
