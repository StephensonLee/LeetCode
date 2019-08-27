package problems;

import java.util.Arrays;

public class P41_Missing {
	public static int firstMissingPositive(int[] nums) {
		Arrays.sort(nums);
		if (nums.length == 0) {
			return 1;
		}
		int n = 0;
		while (n < nums.length && nums[n] < 1) {
			n++;
		}
		if (n == nums.length) {
			return 1;
		}
		int results = 1;
		if (n < nums.length) {
			for (int i = 0; i < nums.length - n; i++) {
				if (nums[n + i] == results) {
					results++;
				} else if (nums[n + i] == results - 1) {

				} else
					return results;
			}
		}
		return results;
	}

	public static void main(String[] args) {
		int[] nums1 = { 0, 2, 2, 1, 1 };
//		int[] nums2 = { 3, 4, -1, 1 };
//		int[] nums3 = { 7, 8, 9, 11, 12 };
		System.out.println(firstMissingPositive(nums1));

	}
}
