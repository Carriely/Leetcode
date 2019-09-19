package com.string;
//**
//字符串解码

import java.util.LinkedList;

public class DecodeString_394 {
	// 解法一：辅助栈法
	// 1、构建辅助栈 stack， 遍历字符串 s 中每个字符 c；
	// 	当 c 为数字时，将数字字符转化为数字 multi，用于后续倍数计算；
	// 	当 c 为字母时，在 res 尾部添加 c；
	// 	当 c 为 [ 时，将当前 multi 和 res 入栈，并分别置空置 0：
	// 		记录此 [ 前的临时结果 res 至栈，用于发现对应 ] 后的拼接操作；
	// 		记录此 [ 前的倍数 multi 至栈，用于发现对应 ] 后，获取 multi × [...] 字符串。
	// 		进入到新 [ 后，res 和 multi 重新记录。
	// 	当 c 为 ] 时，stack 出栈，拼接字符串 res = last_res + cur_multi * res，其中:
	// 		last_res是上个 [ 到当前 [ 的字符串，例如 "3[a2[c]]" 中的 a；
	// 		cur_multi是当前 [ 到 ] 内字符串的重复倍数，例如 "3[a2[c]]" 中的 2。
	// 2、返回字符串 res。
	public String decodeString(String s) {
		StringBuilder res = new StringBuilder();
		int multi = 0;
		LinkedList<String> stack_res = new LinkedList<>();
		LinkedList<Integer> stack_multi = new LinkedList<>();
		for (Character ch : s.toCharArray()) {
			if (ch == '[') {
				stack_res.add(res.toString());
				stack_multi.add(multi);
				multi = 0;
				res = new StringBuilder();
			} else if (ch == ']') {
				StringBuilder temp = new StringBuilder();
				int curMulti = stack_multi.removeLast();
				for (int i = 0; i < curMulti; i++) {
					temp.append(res);
				}
				res = new StringBuilder(stack_res.removeLast() + temp);
			} else if (ch >= '0' && ch <= '9') {
				multi = multi * 10 + Integer.parseInt(ch + "");
			} else {
				res.append(ch);
			}
		}
		return res.toString();
	}
}
