package huiwen;

import java.util.HashMap;

//最长回文串
public class LongestPalindrome_409 {
	// 方法一：int 数组
	public int longestPalindrome(String s) {
		char[] ch = s.toCharArray();
		// 记录每个字母出现的次数
//		int [26] 用于字母 ‘a’ - ‘z’ 或 ‘A’ - ‘Z’
//		int [128] 用于ASCII码
//		int [256] 用于扩展ASCII码
		int[] count = new int[128];// z 对应的 int 数值为 122
		for (int i = 0; i < ch.length; i++) {
			count[ch[i]]++;
		}

		int result = 0;
		for (int i = 0; i < count.length; i++) {
			// 当count中的元素是大于等于2个时，result加上其小于count[i]的最大的偶数
			// 例如，对于字符串 'aaaaa'，其中 'aaaa' 是左右对称，其长度为 5 / 2 * 2 = 4。
			result += count[i] / 2 * 2;
			// 当count[i]为奇数时，且result的数量为偶数时，这个数可以放在中间组成回文的middle
			if (count[i] % 2 == 1 && result % 2 == 0) {
				result++;
			}
		}
		return result;
	}

	// 方法二：Map
	public int longestPalindrome2(String s) {
		char[] ch = s.toCharArray();
		// 记录每个字母出现的次数
		HashMap<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < ch.length; i++) {
			map.put(ch[i], map.getOrDefault(ch[i], 0) + 1);
		}

		int result = 0;
		for (int count : map.values()) {
			// 当count大于等于2个时，result加上其小于count的最大的偶数
			result += count / 2 * 2;
			// 当count为奇数时，且result的数量为偶数时，这个数可以放在中间组成回文的middle
			if (count % 2 == 1 && result % 2 == 0) {
				result++;
			}
		}
		return result;
	}
}
