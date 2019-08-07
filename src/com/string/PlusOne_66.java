package com.string;

//加一
//思路：
//有可能的情况就只有两种：
//	除 9 之外的数字加一；
//	数字 9。
//模拟出进位方式，如十位数加 1 ，个位数置为 0，如此循环直到判断没有再进位就退出循环返回结果。
//特殊情况：当出现 99、999 之类的数字时，循环到最后也需要进位，出现这种情况时需要手动将它进一位。
public class PlusOne_66 {
	public int[] plusOne(int[] digits) {
		for (int i = digits.length - 1; i >= 0; i--) {
			digits[i]++;
			digits[i] = digits[i] % 10;
			if (digits[i] != 0) {
				return digits;
			}
		}
		digits = new int[digits.length + 1];
		digits[0] = 1;
		return digits;
	}
}
