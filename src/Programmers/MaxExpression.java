package Programmers;

import java.util.*;

public class MaxExpression {

	public static void main(String[] args) {
		MaxExpression me = new MaxExpression();

		String expression = "100-200*300-500+20";
		String expression2 = "50*6-3*2";

		long answer1 = me.solution(expression);
		long answer2 = me.solution(expression2);

		System.out.println(answer1 == 60420);
		System.out.println(answer2 == 300);

	}

	public long solution(String expression) {
		long answer = 0;

		List<Character> operators = new ArrayList<>();
		if (expression.contains("+")) {
			operators.add('+');
		}
		if (expression.contains("-")) {
			operators.add('+');
		}
		if (expression.contains("*")) {
			operators.add('+');
		}

		String regex = "";

		for (char oper : operators) {
			regex = regex.concat(String.valueOf(oper));
		}

		Stack<String> stack = new Stack<>();
		LinkedList<String> list = new LinkedList();

		String[] numbers = expression.split(regex);
		int pointer = 0;

		for (String number : numbers) {

			stack.add(number);
			list.add(number);
			pointer += number.length();
			if (pointer >= expression.length()) {
				break;
			}
			String operand = expression.substring(pointer, pointer + 1);
			stack.add(operand);
			list.add(operand);
			pointer += 1;
		}

		
		// 우선순위 6가지 ExpressionTree 만들기
		// 계산 후 최대값 리턴

		
		
		return answer;
	}

}
