package com.array;
//移动零
public class MoveZeroes_283 {
	//将所有的非0数尽可能向前压缩，最后把没压缩的那部分全置0。
	//复杂度:时间 O(N) 空间 O(1)
	public static void moveZeroes(int[] nums) {
		int pos = 0;
        //将非0数字都尽可能向前排
        for(int i=0;i<nums.length;i++){
            if(nums[i] != 0){
                nums[pos]= nums[i];
                pos++;
            }
        }
        //将剩余的都置0
        for(;pos<nums.length; pos++){
            nums[pos] = 0;
        }
    }

	//两次循环，依次比较，非 0则交换位置，复杂度高！
	public static void moveZeroes2(int[] nums){
		if(nums == null || nums.length == 0){
	         System.out.println("空数组！");
	    }
		for(int i=0;i<nums.length-1;i++){
			if(nums[i]==0){
				for(int j=i+1;j<nums.length;j++){
					if(nums[j]!=0){
						int temp = nums[j];
						nums[j] = nums[i];
						nums[i] = temp;
						i++;
					}else{
						continue;
					}
				}
			}else{
				continue;
			}
		}
	}
	//测试
	public static void main(String[] args) {
		int[] arr = new int[]{0,1,0,3,12};
		moveZeroes2(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}
		/*int[] arr = new int[]{5,1,2,3,12};
		moveZeroes2(arr);
		for(int i=0;i<arr.length;i++){
			System.out.println(arr[i]);
		}*/
	}
}
