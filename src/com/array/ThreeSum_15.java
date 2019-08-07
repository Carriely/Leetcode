package com.array;
//求数组中和为0的三个数
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum_15 {
	List<List<Integer>> ans = new ArrayList<List<Integer>>();
	 
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        if (nums == null || length < 3)
            return ans;
        Arrays.sort(nums);//先排序
        for (int i = 0; i < length - 2; ++i) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;//跳过
            findTwoSum(nums, i + 1, length - 1, nums[i]);
        }
        return ans;
    }
 
    //寻找和为0的三个数
    public void findTwoSum(int[] num, int begin, int end, int target) {
        while (begin < end) {
            if (num[begin] + num[end] + target == 0) {
                List<Integer> list = new ArrayList<Integer>();
                list.add(target);
                list.add(num[begin]);
                list.add(num[end]);
                ans.add(list);
                while (begin < end && num[begin + 1] == num[begin])
                    begin++;//跳过
                begin++;
                while (begin < end && num[end - 1] == num[end])
                    end--;//跳过
                end--;
            } else if (num[begin] + num[end] + target > 0)
                end--;//sum > 0，说明num[q]太大了，需要q向前移动。
            else
                begin++;//sum < 0，因为num[q]已经不能增大，所以说明num[p]太小了，这时p需要向后移动，找一个更大的数。
        }
    }
}
