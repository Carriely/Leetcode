package com.string;
//最长公共前缀
public class LongestCommonPrefix_14 {
	public static String longestCommonPrefix(String[] strs) {
        int len = strs.length;
        if(len==0) return "";
        int minLen = 0x7fffffff;//long、int的最大值
        for(String str:strs) {
        	minLen = Math.min(minLen, str.length());
        }
        for(int j=0;j<minLen;++j) {
        	for(int i=1;i<len;++i){
        		if(strs[0].charAt(j)!=strs[i].charAt(j)) {
        			return strs[0].substring(0, j);
        		}
        	}
        }
        return strs[0].substring(0, minLen);
	}
	
	public static void main(String[] args) {
		String[] arr = {"flower","flow","flight"};
		System.out.println(longestCommonPrefix(arr));
	}
}
	

//思路：
//找出最短的那个字符串的长度 minLen，
//然后在 0...minLen 的范围比较所有字符串，如果比较到有不同的字符，那么直接返回当前索引长度的字符串即可，
//否则最后返回最短的字符串即可。
