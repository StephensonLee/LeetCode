package problems;

import java.util.*;

public class P47_PermutationsII {
	public static List<List<Integer>> permute(int[] nums) {
		Arrays.sort(nums);
		List<List<Integer>> list = new ArrayList<List<Integer>>();
		if (nums.length == 0) {
			return list;
		} else {
			List<Integer> cur = new ArrayList<Integer>();
			cur.add(nums[0]);
			list.add(cur);
			if (nums.length == 1) {
				return list;
			} else {
				for (int i = 1; i < nums.length; i++) {
					int len = list.size();
					boolean repeat = nums[i]==nums[i-1];
					for (int j = 0; j < len; j++) {
						int k = 0;
						if (repeat) {
							k=list.get(0).lastIndexOf(nums[i])+1;
						}
						for (; k <= list.get(0).size(); k++) {
							cur = new ArrayList<Integer>(list.get(0));
							cur.add(k, nums[i]);
							list.add(cur);
						}
						list.remove(0);
					}
				}
			}
			return list;
		}
	}

	public static void main(String[] args) {
		int[] nums = { 1,2,3 };
		System.out.println(permute(nums));
		System.out.println(permute(nums).size());
	}
}
