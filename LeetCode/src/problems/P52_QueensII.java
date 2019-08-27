package problems;

public class P52_QueensII {
	public static int solveNQueens(int n) {
		int result = permutation(0, n, new int[n]);
		return result;
	}

	private static int permutation(int row, int n, int[] trace) {
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (check(row, i, trace)) {
				trace[row] = i;
				if (row != n - 1) {
					count += permutation(row + 1, n, trace);
					continue;
				} else {
					count = 1;
				}
			}
		}
		return count;
	}

	private static boolean check(int row, int col, int[] trace) {
		for (int i = 0; i < row; i++) {
			int pos = trace[i];
			int idx1 = col + row;
			int idx2 = col - row;
			if (pos == col || (pos + i) == idx1 || (pos - i) == idx2) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		int i = 4;
		System.out.println(solveNQueens(i));
	}
}