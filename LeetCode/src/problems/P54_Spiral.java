package problems;

import java.util.*;

public class P54_Spiral {
	public static List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> list = new ArrayList<>();
		if (matrix.length == 0)
			return list;
		int lenx = matrix[0].length;
		int leny = matrix.length;
		int min = Math.min(lenx, leny);
		for (int i = 0; i < min / 2; i++) {
			for (int j = i; j < lenx - i - 1; j++) {
				list.add(matrix[i][j]);
			}
			for (int j = i; j < leny - i - 1; j++) {
				list.add(matrix[j][lenx - 1 - i]);
			}
			for (int j = i; j < lenx - 1 - i; j++) {
				list.add(matrix[leny - 1 - i][lenx - 1 - j]);
			}
			for (int j = i; j < leny - 1 - i; j++) {
				list.add(matrix[leny - 1 - j][i]);
			}
		}
		if (min == lenx && lenx % 2 == 1) {
			for (int i = min / 2; i < leny - min / 2; i++) {
				list.add(matrix[i][lenx / 2]);
			}
		} else if (min == leny && leny % 2 == 1) {
			for (int i = min / 2; i < lenx - min / 2; i++) {
				list.add(matrix[leny / 2][i]);
			}
		}
		return list;
	}

	public static void main(String[] args) {
//		int[][] matrix1 = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
//		int[][] matrix2 = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 } };
		int[][] matrix3 = {{6,9,7}};
		System.out.println(spiralOrder(matrix3));
	}
}
