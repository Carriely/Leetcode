package huiwen;
//计算字符串中有多少个回文子串
public class CountSubstrings_647 {
	// 方法一：动态规划
	// 方法二：中心扩展法
	public int countSubstrings2(String str) {
		int result = 0;
		for (int i = 0; i < str.length(); i++) {
			result += countSegment(str, i, i);
			result += countSegment(str, i, i + 1);
		}
		return result;
	}

	public int countSegment(String s, int start, int end) {
		int count = 0;
		while (start >= 0 && end < s.length() && s.charAt(start--) == s.charAt(end++)) {
			count++;
		}
		return count;
	}
}
