package problems;

import java.util.ArrayList;
import java.util.Arrays;

public class P57_Insert {
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		ArrayList<int[]> list = new ArrayList<int[]>(Arrays.asList(intervals));
		int i=0;
		while (i<list.size()&&list.get(i)[1]<newInterval[0]) i++;
		list.add(i,newInterval);
		for (;i < list.size() - 1; i++) {
			if (list.get(i)[1] < list.get(i + 1)[0]) {
				break;
			} else {
				list.add(i + 2, new int[] { Math.min(list.get(i)[0], list.get(i + 1)[0]),
						Math.max(list.get(i)[1], list.get(i + 1)[1]) });
				list.remove(i);
				list.remove(i);
				i--;
			}
		}
		int[][] result = list.toArray(new int[list.size()][2]);
		return result;
	}

	public static void main(String[] args) {
//		int[][] nums = { { 1, 3 }, { 6, 9 } };
//		int[] newInterval = { 2, 5 };

		int[][] nums1 = { { 1, 2 }, { 3, 5 }, { 6, 7 }, { 8, 10 }, { 12, 16 } };
		int[] newInterval1 = { 4, 8 };

		int[][] results = insert(nums1, newInterval1);

		for (int i = 0; i < results.length; i++) {
			System.out.print(results[i][0]);
			System.out.print(' ');
			System.out.print(results[i][1]);
			System.out.println();
		}
	}
}
