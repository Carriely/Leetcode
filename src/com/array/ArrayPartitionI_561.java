package com.array;
//数组拆分
import java.util.Arrays;
import java.util.Random;

//先排序，经分析可知将相邻两个数分为一组，求每组左边较小数之和即可，也就是求排序后索引为0、2、4……2n的数之和
public class ArrayPartitionI_561 {
	public static int arrayPairSum(int[] nums) {
	  //排除数组为空的情况
      if(nums == null || nums.length == 0){
          return 0;
      }
      
      Arrays.sort(nums);
      int res = 0;
      for(int i = 0; i<nums.length; i+=2){
         res += nums[i];
      }
      return res;
    }
	
	//测试
	public static void main(String[] args) {
		Random rdm = new Random();
		int[] arr = new int[100];
		for(int i=0;i<100;i++){
			int r = rdm.nextInt(101);//生成0~100之间的整数
			//int r = (int) (Math.random()*100); //Math.random()返回0.0~1.0之间的随机数
			arr[i] = r;
		}
		//打印数组
		for(int i:arr){
			System.out.println(i);
		}
		System.out.println("res:"+arrayPairSum(arr));
	}
}
