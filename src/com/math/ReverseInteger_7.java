package com.math;
//反转整数
public class ReverseInteger_7 {
	public static int reverse(int x) {
        long res = 0;
        for(;x != 0;x /= 10) {
        	res = res * 10 + x % 10;
        }
        return (res > Integer.MAX_VALUE || res < Integer.MIN_VALUE)? 0 : (int)res;//超出范围均取0
    }
	public static void main(String[] args) {
		System.out.println(reverse(-123));
	}
}
