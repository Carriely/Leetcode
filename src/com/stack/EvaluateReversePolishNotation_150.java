package com.stack;

import java.util.Stack;

//计算逆波兰表达式（后缀表达式）
//解法：
//利用栈来模拟计算：
//遇到操作数直接压栈，碰到操作符直接取栈顶的2个操作数进行计算（注意第一次取出来的是右操作数），然后再把计算结果压栈，如此循环下去。
//最后栈中剩下的唯一一个元素便是整个表达式的值
public class EvaluateReversePolishNotation_150 {
	public int evalRPN(String[] tokens) {
		Stack<Integer> stack = new Stack<Integer>();
		for (int i = 0; i < tokens.length; i++) {
			if (tokens[i].equals("+") || tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
				int op2 = stack.pop();
				int op1 = stack.pop();
				stack.push(op(op1, op2, tokens[i]));
			} else {
				stack.push(Integer.parseInt(tokens[i]));
			}
		}
		return stack.pop();
	}

	public int op(int op1, int op2, String symbol) {
		if (symbol.equals("+")) {
			return op1 + op2;
		} else if (symbol.endsWith("-")) {
			return op1 - op2;
		} else if (symbol.equals("*")) {
			return op1 * op2;
		} else {
			return op1 / op2;
		}
	}

}
