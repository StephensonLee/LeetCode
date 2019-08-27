package problems;

import java.util.*;

public class P56_Intervals {
	public static int[][] merge(int[][] intervals) {
		Arrays.sort(intervals, new Comparator<int[]>() {
			public int compare(int[] nums1, int[] nums2) {
				if  (nums1[0]!=nums2[0]) {
					return nums1[0] - nums2[0];
				}else return nums1[1] - nums2[1];
			}
		});
		ArrayList<int[]> list = new ArrayList<int[]> (Arrays.asList(intervals));
		for (int i = 0; i < list.size()-1; i++) {
			if (list.get(i)[1] >= list.get(i+1)[0]) {
					list.add(i+2,new int[] {Math.min(list.get(i)[0],list.get(i+1)[0]),Math.max(list.get(i)[1],list.get(i+1)[1])});
					list.remove(i);
					list.remove(i);
					i--;
			}
		}
		System.out.println(list.size());
		int[][] results = list.toArray(new int[list.size()][2]);
		return results;
	}

	public static void main(String[] args) {
		int[][] nums = { { 1, 3 },{ 2, 6 }, { 8, 10 }, { 15, 18 } };
//		int[][] nums1 = { { 1, 3 },{ 1, 2 }, { 8, 10 }, { 15, 18 } };
		int[][] nums2 = { { 1, 4 },{ 0, 2 },{3,5}};
//		int[][] nums3 = {{}};
		ArrayList<int[]> list = new ArrayList<int[]> (Arrays.asList(nums));
		System.out.println(list.get(0)[0]);
		int[][] a = list.toArray(new int[list.size()][2]);
		System.out.println(a[0][0]);
//		int[][] nums1 = { { 1, 4 }, { 4, 5 } };
		int[][] results = merge(nums2);
		System.out.println(results.length);
		for (int i = 0; i < results.length; i++) {
			System.out.print(results[i][0]);
			System.out.print(' ');
			System.out.print(results[i][1]);
			System.out.println();
		}
	}
}
