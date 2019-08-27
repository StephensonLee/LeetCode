package problems;

public class P36_Sudoku {
	public static boolean valid(char[][] board) {
		for (int i = 0; i < 9; i++) {
			int[] st = new int[9];
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.') {
					if (st[board[i][j] - '1'] != 1) {
						st[board[i][j] - '1'] = 1;
					} else
						return false;
				}
			}
		}
		for (int i = 0; i < 9; i++) {
			int[] st = new int[9];
			for (int j = 0; j < 9; j++) {
				if (board[j][i] != '.') {
					if (st[board[j][i] - '1'] != 1) {
						st[board[j][i] - '1'] = 1;
					} else
						return false;
				}
			}
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int[] st = new int[9];
				for (int k = 0; k < 3; k++) {
					for (int l = 0; l < 3; l++) {
						if (board[3*i+k][3*j+l] != '.') {
							if (st[board[3*i+k][3*j+l] - '1'] != 1) {
								st[board[3*i+k][3*j+l] - '1'] = 1;
							} else
								return false;
						}
					}
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String[][] input = {
				{ "5", "3", ".", ".", "7", ".", ".", ".", "." },
				{ "6", ".", ".", "1", "9", "5", ".", ".", "." },
				{ ".", "9", "8", ".", ".", ".", ".", "6", "." },
				{ "8", ".", ".", ".", "6", ".", ".", ".", "3" },
				{ "4", ".", ".", "8", ".", "3", ".", ".", "1" },
				{ "7", ".", ".", ".", "2", ".", ".", ".", "6" },
				{ ".", "6", ".", ".", ".", ".", "2", "8", "." },
				{ ".", ".", ".", "4", "1", "9", ".", ".", "5" },
				{ ".", ".", ".", ".", "8", ".", ".", "7", "9" } };
		char[][] board = new char[9][9];
		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				board[i][j] = input[i][j].charAt(0);
			}
		}
		System.out.println(valid(board));
	}
}
