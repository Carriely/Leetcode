package com.tree;
//汉明距离
public class HammingDistance_461 {
	public static int hammingDistance(int x, int y) {
		int result = x ^ y;
		int count = 0;
//		String str = Integer.toString(result);
//		System.out.println(str);
		String r = Integer.toBinaryString(result);// 将结果转成二进制数
		System.err.println(r);
		for (int i = 0; i < r.length(); i++) {
			char ch = r.charAt(i);
			if ("1".equals(ch + "")) {
				count++;
			}
		}
		return count;
	}

	public static void main(String[] args) {
		int count = hammingDistance(1, 4);
		System.out.println(count);
	}
}
