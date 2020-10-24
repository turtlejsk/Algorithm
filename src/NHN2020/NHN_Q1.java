package NHN2020;

import static org.junit.Assert.assertEquals;

import java.util.Stack;

import org.junit.Test;

public class NHN_Q1 {
	@Test
	public void test() {

		NHN_Q1 n1 = new NHN_Q1();

		int numOfOrder1 = 1;
		String[] orderArr1 = { "3(R2(GB))" };

		n1.solution(numOfOrder1, orderArr1);

	}

	private static void solution(int numOfOrder, String[] orderArr) {
		// TODO: 이곳에 코드를 작성하세요. 추가로 필요한 함수와 전역변수를 선언해서 사용하셔도 됩니다.
		for (int i = 0; i < numOfOrder; i++) {
			String order = orderArr[i];
			StringBuffer sb = new StringBuffer();
			Stack<Character> stack = new Stack();
			Stack<Character> assembler = new Stack();
			Stack<String> chunk = new Stack();
			for (int j = 0; j < order.length(); j++) {
				char c = order.charAt(j);
				stack.push(c);
				if (c == ')') {
					char top = stack.peek();
					while (top != '(') {
						top = stack.pop();
						if (top != ')') {
							assembler.push(top);
						}
						if (top == '(') {
							assembler.pop();
						}
					}

					top = stack.pop();
					System.out.println(top);

					if (isRGB(top)) {
						System.out.println(top + " is RGB");
						String ch = "";
						while (!assembler.isEmpty()) {
							ch = ch.concat(String.valueOf(top));
							ch = ch.concat(String.valueOf(assembler.pop()));
						}
						chunk.push(ch);
						System.out.println(ch);
					} else {
						String ch = "";
						while (!assembler.isEmpty()) {
							ch = ch.concat(String.valueOf(assembler.pop()));
						}
						String tmp = "";
						for (int k = 0; k < top - '0'; k++) {
							tmp = ch.concat(ch);
						}
						chunk.push(tmp);
						System.out.println(tmp);
					}
				}
			}

		}
	}

	private static boolean isRGB(char c) {
		if (c == 'R') {
			return true;
		}
		if (c == 'G') {
			return true;
		}
		if (c == 'B') {
			return true;
		}
		return false;
	}

	private static boolean isBracket(char c) {
		if (c == '(') {
			return true;
		}
		if (c == ')') {
			return true;
		}
		return false;
	}

}
