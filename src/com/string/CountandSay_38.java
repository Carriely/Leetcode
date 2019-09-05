package com.string;
//报数

//下一个数的表示结果是上一个数"say"出来的结果：
//   首先1，自然表示为 1，而"say"出来就是1个1,
//   所以2应该表示为 11，而"say"出来就是两（2）个1，
//   所以3应该表示为 21，而"say"出来就是1个2，1个1，
//   所以4应该表示为 1211，以此类推...

public class CountandSay_38 {
	public String countAndSay(int n) {
		if (n <= 0) {
			return "";
		}
		String[] str = new String[n];
		str[0] = "1";
		for (int i = 1; i < n; i++) {
			str[i] = convert(str[i - 1]);
		}
		return str[n - 1];
	}

	private String convert(String str) {
		StringBuilder builder = new StringBuilder();
		int count = 1;
		for (int i = 0; i < str.length(); i++) {
			// 这一部分是"count", 记录连续出现x个y
			if (i < str.length() - 1 && str.charAt(i) == str.charAt(i + 1)) {
				count++;
			} else {
				// 这一部分是"say"，将上面"count"的结果"xy"作为下一个数的一部分（若上面记录到2个1，就拼接"21"）
				builder.append(count).append(str.charAt(i));
				count = 1;
			}
		}
		return new String(builder);
	}
}
