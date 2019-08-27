package problems;

public class P41_1 {
    public static int firstMissingPositive(int[] nums) {
        int len = nums.length + 1;
         for(int i = 0; i < nums.length; i++){
             nums[i] = nums[i] <= 0 || nums[i] > len ? len:nums[i];
         }
         for(int i = 0; i < nums.length; i ++){
             if(nums[i] == len || nums[i] == -len)
                 continue;
             int idx = nums[i] < 0 ? -1*nums[i]:nums[i];
             if(nums[idx-1] < 0)
                 continue;
             nums[idx-1] *= -1;
         }
         int i = 0;
         for(; i<nums.length; i ++)
             if(nums[i] >= 0)
                 break;
         return i+1;
     }
	public static void main(String[] args) {
//		int[] nums1 = { 0, 2, 2, 1, 1 };
//		int[] nums2 = { 3, 4, -1, 1 };
		int[] nums3 = { 7, 8, 9, 11, 12 };
		System.out.println(firstMissingPositive(nums3));

	}
}
