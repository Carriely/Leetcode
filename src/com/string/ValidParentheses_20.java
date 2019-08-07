package com.string;
//有效的括号（栈）

public class ValidParentheses_20 {
	public static boolean isValid(String s) {
		char[] stack = new char[s.length()+1];
		int top = 1;
		for(char c:s.toCharArray()) {
			if(c == '(' || c == '{' || c == '[') {
				stack[top++] = c;
			}else if(c == ')' && stack[--top] != '(') {
				return false;
			}else if(c == '}' && stack[--top] != '{') {
				return false;
			}else if(c == ']' && stack[--top] != '[') {
				return false;
			}
		}
        return top == 1; 
    }
	public static void main(String[] args) {
		System.out.println(isValid("([)]"));
	}
}


//思路：
//当出现左括号的时候入栈，
//当遇到右括号时，判断栈顶的左括号是否何其匹配，不匹配的话直接返回 false 即可，最终判断是否空栈即可，
//用数组模拟栈的操作使其操作更快，
//注意：top = 1，从而省去了之后判空的操作和 top - 1 导致数组越界的错误。