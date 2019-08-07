package com.math;
//回文数
public class PalindromeNumber_9 {
	//思路1:先求出该数的回文数，与定值比较
	public static boolean isPalindrome(int x) {
        if(x<0) return false;
        int copyX = x;//保证原来的x不变
        int reverse = 0;
        for(;copyX>0;copyX/=10) {
        	reverse = reverse * 10 + copyX % 10;
        }
        System.out.println(reverse);
        return x == reverse ;
    }
	//思路2……
	public static void main(String[] args) {
		System.out.println(isPalindrome(12321));
	}
}


