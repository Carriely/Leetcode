package com.string;

//***
// 二进制求和
public class AddBinary_67 {
	public String addBinary(String a, String b) {
		StringBuilder result = new StringBuilder();
		// 进位
		int carry = 0;
		for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
			// 对应位相加之和
			int currentSum = carry;// 把每一轮的进位先放进去
			// 将两个字符串较短的用 0 补齐，否则获取当前数值
			currentSum += i >= 0 ? a.charAt(i) - '0' : 0;
			currentSum += j >= 0 ? b.charAt(j) - '0' : 0;
			result.append(currentSum % 2);// 模2为当前位的和
			carry = currentSum / 2;// 除以2为进位的值
		}
		result.append(carry == 1 ? carry : "");// 最后如果还有进位，添加一位
		// 需要进行反转
		return result.reverse().toString();
	}
}
