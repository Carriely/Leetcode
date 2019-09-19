package com.string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

// 无重复字符的最长子串
// 参考：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters/solution/wu-zhong-fu-zi-fu-de-zui-chang-zi-chuan-by-leetcod/
public class LengthOfLongestSubstring_3 {
	// 滑动窗口
	// 使用 HashSet 将字符存储在当前窗口 [i, j)（最初 j = i）中
	// 时间复杂度：O(2n) = O(n)
	public int lengthOfLongestSubstring(String s) {
		int n = s.length();
		// 使用 HashSet 作为滑动窗口，可以用 O(1) 的时间来完成对字符是否在当前的子字符串中的检查。
		Set<Character> set = new HashSet<>();
		int res = 0;
		int i = 0, j = 0;
		while (i < n && j < n) {
			if (!set.contains(s.charAt(j))) {
				set.add(s.charAt(j++));
				res = Math.max(res, j - i);// 滑动窗口左闭右开
			} else {
				set.remove(s.charAt(i++));
			}
		}
		return res;
	}

	// ***
	// 优化的滑动窗口（使用 HashMap）
	// 如果 s[j] 在 [i, j) 范围内有与 j'重复的字符，不需要逐渐增加 i。
	// 可以直接跳过 [i，j'] 范围内的所有元素，并将 i 变为 j' + 1
	// 时间复杂度：O(n)
	public int lengthOfLongestSubstring2(String s) {
		int n = s.length();
		int res = 0;
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0, j = 0; j < n; j++) {
			if (map.containsKey(s.charAt(j))) {
				i = Math.max(map.get(s.charAt(j)), i);
			}
			res = Math.max(res, j - i + 1);
			map.put(s.charAt(j), j + 1);
		}
		return res;
	}
}
