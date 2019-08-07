package com.array;
//求最后一个单词的长度
public class LengthofLastWord_58 {
	//倒序遍历
	public static int lengthOfLastWord(String s) {
		int p = s.length()-1;
		//先去掉末尾的空格
		while (p>=0 && s.charAt(p)==' ') p--;
		int end = p;
		//再寻找该字符串中倒数第一个空格
		while(p>=0 && s.charAt(p)!=' ') p--;
		return end - p;
	}
	//API
	public int lengthOfLastWord1(String s) {
	    return s.trim().length()-s.trim().lastIndexOf(" ")-1;//s.trim()去掉字符串两端多余的空格
	}
	public static void main(String[] args) {
		System.out.println(lengthOfLastWord("hello world   "));
	}
}
