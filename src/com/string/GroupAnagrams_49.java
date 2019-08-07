package com.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
//字母异位词分组
//思路：
//当且仅当它们的排序字符串相等时，两个字符串是字母异位词。
public class GroupAnagrams_49 {
	public static List<List<String>> groupAnagrams(String[] strs) {
		if (strs == null || strs.length == 0) {
			return new ArrayList();
		}
		Map<String, List> map = new HashMap<String, List>();
		for (String s : strs) {
			char[] ch = s.toCharArray();
			Arrays.sort(ch);
			String key = String.valueOf(ch);
			if (!map.containsKey(key)) {
				map.put(key, new ArrayList());
			} 
			map.get(key).add(s);//不能放在else块中执行，区别在于执行完if条件是否执行该语句
		}
		return new ArrayList(map.values());
	}
	
	public static void main(String[] args) {
		String[] strings = {"eat","tea","tan","ate","nat","bat"};
		List<List<String>> list = groupAnagrams(strings);
		for(int i=0;i<list.size();i++) {
			System.err.println(list.get(i));
		}
	}
}
