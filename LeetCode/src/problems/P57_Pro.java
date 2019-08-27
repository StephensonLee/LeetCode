package problems;

public class P57_Pro {
	public static int[][] insert(int[][] intervals, int[] newInterval) {
		if (intervals.length==0) return new int[][] {newInterval};
		int start=0;
		int end =intervals.length;
		boolean s = true;
		boolean e = true;
		for (int i = 0; i < intervals.length; i++) {
			if (s&&newInterval[0] <= intervals[i][1]) {
				start = i;
				s=false;
			}
			if (e&&newInterval[1] < intervals[i][0]) {
				end = i;
				e=false;
			}
		}
		if (s) start=intervals.length;
		if (e) end = intervals.length;

		System.out.println(start);
		System.out.println(end);
		int[][] results = new int[intervals.length-(end-start)+1][2];
		for(int i =0;i<start;i++) {
			results[i][0]=intervals[i][0];
			results[i][1]=intervals[i][1];
		}
		if (start==end) {
			results[start][0]=newInterval[0];
			results[start][1]=newInterval[1];
		} else {
			results[start][0]=Math.min(intervals[start][0], newInterval[0]);
			results[start][1]=Math.max(intervals[end-1][1], newInterval[1]);
		}

		for(int i =end;i<intervals.length;i++) {
			results[i-end+start+1][0]=intervals[i][0];
			results[i-end+start+1][1]=intervals[i][1];
		}
		return results;
	}

	public static void main(String[] args) {
		int[][] nums = { { 5, 8 }};
		int[] newInterval = { 3, 5 };


		int[][] results = insert(nums, newInterval);

		for (int i = 0; i < results.length; i++) {
			System.out.print(results[i][0]);
			System.out.print(' ');
			System.out.print(results[i][1]);
			System.out.println();
		}
	}
}
