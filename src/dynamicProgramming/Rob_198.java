package dynamicProgramming;
//打家劫舍
//思路：f(k) = 从前 k 个房屋中能抢劫到的最大数额，Ai= 第 i 个房屋的钱数。
//f(–1) = f(0) = 0
//f(k) = max(f(k – 2) + Ak , f(k – 1))
//优化：可以用一个数组来存储并计算结果。不过由于每一步你只需要前两个最大值，两个变量就足够用了。
public class Rob_198 {
	public int rob(int[] nums) {
		int currMax = 0;
		int prevMax = 0;
		for (int x : nums) {
			int temp = currMax;
			currMax = Math.max(prevMax + x, currMax);
			prevMax = temp;
		}
		return currMax;
	}
}
