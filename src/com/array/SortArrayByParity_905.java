package com.array;
//按奇偶排序数组
import java.util.ArrayList;
import java.util.List;

public class SortArrayByParity_905 {
	public int[] sortArrayByParity(int[] A) {
		//创建一个偶数list和奇数list，然后合并转化为数组
        List<Integer> evenList = new ArrayList<Integer>();
        List<Integer> oddList = new ArrayList<Integer>();
        for(int i = 0;i < A.length;i++) {
        	if(A[i] % 2 == 0) {
        		evenList.add(A[i]);
        	}else {
        		oddList.add(A[i]);
        	}
        }
        evenList.addAll(oddList);
        int[] newArr = new int[A.length];
        for(int i = 0;i<evenList.size();i++) {
        	newArr[i] = evenList.get(i);
        }
        return newArr;
    }
}
