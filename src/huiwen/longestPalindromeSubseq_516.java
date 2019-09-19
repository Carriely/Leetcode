package huiwen;
//最长回文子序列

//注意是子序列而不是子串！ 
//子串是连续的，比如”abda”最长回文子串就是”a”或者”b”
//子序列是不连续的，比如”abda”最长子序列就是”aba”或者”ada”

//思路：
//状态：f[i][j] 表示 s 的第 i 个字符到第 j 个字符组成的子串中，最长的回文序列长度是多少。
//转移方程
//如果 s 的第 i 个字符和第 j 个字符相同的话：f[i][j] = f[i + 1][j - 1] + 2
//如果 s 的第 i 个字符和第 j 个字符不同的话：f[i][j] = max(f[i + 1][j], f[i][j - 1])

public class longestPalindromeSubseq_516 {
	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] maxLength = new int[n][n];
		// 注意遍历顺序，i 从最后一个字符开始往前遍历，j 从 i + 1 开始往后遍历，这样可以保证每个子问题都已经算好了
		for (int i = n - 1; i >= 0; i--) {
			// 初始化：单个字符的最长回文序列是 1
			maxLength[i][i] = 1;
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					maxLength[i][j] = maxLength[i + 1][j - 1] + 2;
				} else {
					maxLength[i][j] = Math.max(maxLength[i][j - 1], maxLength[i + 1][j]);
				}
			}
		}
		return maxLength[0][n - 1];
	}
}

//如果已知一个回文数s，那么具有什么性质呢？
//1、在s左右两边加相同的字符c，则回文数的长度+2，即csc也为回文数，并且长度为len(s) + 2
//2、在其左右两边加不同的字符a、b，则最长回文数的长度不变; 即asb中，只有s部分为回文数;换句话说as或sb中的最长回文数等于s
