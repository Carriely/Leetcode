package com.math;

//除自身以外数组的乘积
//思路：乘积 = 当前数左边的乘积 * 当前数右边的乘积
//参考：https://blog.csdn.net/qq_17550379/article/details/83854155
public class ProductExceptSelf_238 {
	public int[] productExceptSelf(int[] nums) {
		int[] res = new int[nums.length];
		int k = 1;
		for (int i = 0; i < nums.length; i++) {
			res[i] = k;
			k = k * nums[i];// 此时数组存储的是除去当前元素左边的元素乘积
		}
		k = 1;
		for (int i = nums.length - 1; i >= 0; i--) {
			res[i] *= k;// 此时数组等于当前数左边的乘积 * 当前数右边的乘积
			k *= nums[i];// k为该数右边的乘积
		}
		return res;
	}
}
