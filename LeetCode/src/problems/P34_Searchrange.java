package problems;

public class P34_Searchrange {
	public static int[] range(int[] nums, int target) {
		int[] results = new int[2];
		results[0] = -1;
		results[1] = -1;
		if (nums.length > 0) {
			for (int i = 0, j = nums.length - 1; i <= j;) {
				if (nums[i] == target) {
					if (results[0] == -1)
						results[0] = i;
				} else if (nums[(i + j) / 2] < target) {
					i = (i + j) / 2;
					i++;
				} else
					i++;

				if (nums[j] == target) {
					if (results[1] == -1)
						results[1] = j;
				} else if (nums[(i + j) / 2] > target) {
					j = (i + j) / 2;
					j--;
				} else
					j--;
				if (results[0] != -1 && results[1] != -1)
					break;
			}
		}
		return results;
	}

	public static void main(String[] args) {
		int[] nums = { 5, 7, 7, 8, 8, 10 };
		int target = 8;
		int[] results = range(nums, target);
		System.out.println(results[0]);
		System.out.println(results[1]);
	}
}
