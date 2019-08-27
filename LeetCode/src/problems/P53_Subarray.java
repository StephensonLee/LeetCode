package problems;

public class P53_Subarray {
	public static int maxSubArray(int[] nums) {
		int sum=0;
		int summax=nums[0];
		for (int i=0;i<nums.length;i++) {
			sum+=nums[i];
			if (nums[i]>=0) {
				if (sum>summax) {
					summax=sum;
				}
			} else if (sum<0) {
				sum=0;
				if (summax<nums[i]) {
					summax=nums[i];
				}
			}
		}
		return summax;
	}

	public static void main(String[] args) {
		int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
//		nums = new int[] {-1,0,-2};
		System.out.println(maxSubArray(nums));

	}
}
