package problems;

public class P35_Insert {
	public static int searchInsert(int[] nums, int target) {
		for (int i =0 ;i<nums.length;i++) {
			if (nums[i]>=target) {
				return i;
			}
		}
		return nums.length;
	}
	public static void main(String[] args) {
		int[] input = {1,3,5,6};
		int target = 0;
		System.out.println(searchInsert(input,target));
	}
}
