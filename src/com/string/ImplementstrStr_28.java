package com.string;
//实现strStr()
public class ImplementstrStr_28 {
	//双指针
	public static int strStr(String haystack, String needle) {
		if(haystack.length() < needle.length()) return -1;
		//注意i、j的取值范围！
        for(int i=0; ;i++) {
        	//当剩下的haystack字串长度小于needle长度时，不需要继续比较即可返回-1
        	if(i + needle.length() > haystack.length()) return -1;
        	for(int j=0; ;j++) {
        		//比较相同的字母次数达到needle长度即匹配成功
    			if(j==needle.length()) return i;
    			//出现不同字母即跳出本次循环
    			if(haystack.charAt(i+j)!=needle.charAt(j)) break;
        	}
        }
    }
	public static void main(String[] args) {
		System.out.println(strStr("hello", "ll"));
	}
}
