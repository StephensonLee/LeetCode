package problems;

import java.util.*;

public class P39_Combination {
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
		ArrayList<List<Integer>> results = new ArrayList<List<Integer>>();
		Arrays.sort(candidates);
		if (target < candidates[0]) {
			return results;
		} else {
			if (Arrays.binarySearch(candidates, target) >= 0) {
				ArrayList<Integer> List = new ArrayList<Integer>();
				List.add(target);
				results.add(List);
			}
			for (int i = 0; i < candidates.length; i++) {
				int[] candidates1 = Arrays.copyOfRange(candidates, 0, i + 1);
				List<List<Integer>> cur = combinationSum(candidates1, target - candidates[i]);
				for (int j = 0; j < cur.size(); j++) {
					cur.get(j).add(candidates[i]);
				}
				results.addAll(cur);
			}
			return results;
		}
	}

	public static void main(String[] args) {
		int[] candidates = { 8, 7, 4, 3 };
		int target = 7;
		System.out.println(combinationSum(candidates, target));
	}

}
