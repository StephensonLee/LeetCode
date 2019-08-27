package problems;

public class P74_Search {
	public static boolean searchMatrix(int[][] matrix, int target) {
		if (matrix.length == 0 || matrix[0].length == 0)
			return false;
		int row1 = 0, row2 = matrix.length - 1, col1 = 0, col2 = matrix[0].length - 1;
		while (row2 != row1) {
			if (matrix[(row1 + row2) / 2][col2] < target) {
				row1 = (row1 + row2) / 2 + 1;
			} else {
				row2 = (row1 + row2) / 2;
			}
		}
		while (col2 != col1) {
			if (matrix[row1][(col1 + col2) / 2] < target) {
				col1 = (col1 + col2) / 2 + 1;
			} else {
				col2 = (col1 + col2) / 2;
			}
		}
		return matrix[row1][col1] == target;
	}

	public static void main(String[] args) {
		int[][][] matrix = { { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 50 } }, {}, };
		int[] target = { 3, 13 };
		for (int i = 0; i < matrix.length; i++) {
			System.out.println(searchMatrix(matrix[i], target[i]));
		}
	}
}
