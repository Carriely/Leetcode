package huiwen;

//最长回文串
public class LongestPalindrome_409 {
	public int longestPalindrome(String s) {
		char[] ch = s.toCharArray();
		// 记录每个字母出现的次数
		int[] count = new int[128];
		for (int i = 0; i < ch.length; i++) {
			count[ch[i]]++;
		}

		int result = 0;
		for (int i = 0; i < count.length; i++) {
			// 当count中的元素是大于等于2个时，result加上其小于count[i]的最大的偶数
			result += count[i] / 2 * 2;
			// 当count[i]为奇数时，且result的数量为偶数时，这个数可以放在中间组成回文的middle
			if (count[i] % 2 == 1 && result % 2 == 0) {
				result++;
			}
		}
		return result;
	}
}
