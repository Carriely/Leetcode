package huiwen;

//最长回文子串
//参考：https://leetcode-cn.com/problems/longest-palindromic-substring/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-bao-gu/
public class longestPalindrome_5 {
	// 方法一：求最长公共子串（动态规划）
	public String longestPalindrome(String s) {
		if (s.equals("")) {
			return "";
		}
		return "";
	}

	// 方法二：扩展中心
	// 每次循环选择一个中心，进行左右扩展，判断左右字符是否相等即可。
	public String longestPalindrome2(String s) {
		if (s == null || s.length() < 1) {
			return "";
		}
		int start = 0,end = 0;
		for (int i = 0; i < s.length(); i++) {
			// 获取到当前点i 的奇回文和偶回文的最大长度
			int len1 = expandAroundCenter(s, i, i);
			int len2 = expandAroundCenter(s, i, i + 1);
			int len = Math.max(len1, len2);
			// 取最大长度，然后扩展
			if (len > (end - start)) {
				start = i - (len - 1) / 2;
				end = i + len / 2;
			}
		}
		return s.substring(start, end + 1);
	}

	// 由中心往两边扩散，返回满足最大回文的长度
	private int expandAroundCenter(String s, int start, int end) {
		// 注意是while循环而不是if判断
		while (start >= 0 && end < s.length() && s.charAt(start) == s.charAt(end)) {
			start--;
			end++;
		}
		return end - start - 1;
	}
}