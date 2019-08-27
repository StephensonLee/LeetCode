package problems;

public class P37_Sudokusolver {
	public static int[] check(char[][] board, int i, int j) {
		int[] st = new int[9];
		for (int k = 0; k < 9; k++) {
			if (board[i][k] != '.') {
				st[board[i][k] - '1'] = 1;
			}
			if (board[k][j] != '.') {
				st[board[k][j] - '1'] = 1;
			}
		}
		for (int k = 0; k < 3; k++) {
			for (int l = 0; l < 3; l++) {
				if (board[i / 3 * 3 + k][j / 3 * 3 + l] != '.') {
					st[board[i / 3 * 3 + k][j / 3 * 3 + l] - '1'] = 1;
				}
			}
		}
		return st;
	}

	public static int[] locate(char[][] board) {
		int min = 9;
		int[] result = { 0, 0 };
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.') {
					int[] st = check(board, i, j);
					int count = 0;
					for (int k = 0; k < 9; k++) {
						if (st[k] == 0)
							count++;
					}
					if (count < min) {
						min = count;
						result[0] = i;
						result[1] = j;
					}
				}
			}
		}
		if (min == 0) {
			result[0] = -1;
			result[1] = -1;
		}
		return result;
	}

	public static boolean complete(char[][] board) {
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				if (board[i][j] == '.')
					return false;
			}
		}
		return true;
	}

	public static char[][] optimize(char[][] board) {
		char[][] out = board;
		int min = 1;
		while (min == 1) {
			min = 9;
			for (int i = 0; i < 9; i++) {
				for (int j = 0; j < 9; j++) {
					if (board[i][j] == '.') {
						int[] st = check(board, i, j);
						int count = 0;
						int cur = 0;
						for (int k = 0; k < 9; k++) {
							if (st[k] == 0) {
								count++;
								cur = k;
							}
						}
						if (count == 1) {
							out[i][j] = (char) (cur + 49);
							min = 1;
						}
					}
				}
			}
		}
		return out;
	}

	public static char[][] solve(char[][] board) {
		board = optimize(board);
		int[] location = locate(board);
		if (location[0] == -1)
			return board;
		int[] nums = check(board, location[0], location[1]);
		for (int i = 0; i < 9; i++) {

			if (nums[i] == 0) {
				board[location[0]][location[1]] = (char) (i + 49);
				board = solve(board);
				if (complete(board) == true)
					return board;
				board[location[0]][location[1]] = '.';
			}
		}
		return board;
	}

	public static void main(String[] args) {
		String[][] input = { { ".", ".", ".", ".", ".", "7", ".", ".", "9" },
				{ ".", "4", ".", ".", "8", "1", "2", ".", "." }, { ".", ".", ".", "9", ".", ".", ".", "1", "." },
				{ ".", ".", "5", "3", ".", ".", ".", "7", "2" }, { "2", "9", "3", ".", ".", ".", ".", "5", "." },
				{ ".", ".", ".", ".", ".", "5", "3", ".", "." }, { "8", ".", ".", ".", "2", "3", ".", ".", "." },
				{ "7", ".", ".", ".", "5", ".", ".", "4", "." }, { "5", "3", "1", ".", "7", ".", ".", ".", "." } };

		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = input[i][j].charAt(0);
			}
		}
		System.out.println(complete(board));
		board = solve(board);
		System.out.println(complete(board));

		for (int m = 0; m < 9; m++) {
			System.out.println(board[m]);
		}
	}
}
