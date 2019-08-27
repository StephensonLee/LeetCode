package problems;

public class P72_Pro {
	public static int minDistance(String word1, String word2) {
		int len1 = word1.length();
		int len2 = word2.length();
		if (len1 == 0 || len2 == 0)
			return len1 + len2;
		int[][] res = new int[len2][len1];
		res[0][0] = word1.charAt(0) == word2.charAt(0) ? 0 : 1;
		for (int i = 1; i < len1; i++)
			res[0][i] = Math.min(i + (word1.charAt(i) == word2.charAt(0) ? 0 : 1), res[0][i-1]+1);
		for (int i = 1; i < len2; i++)
			res[i][0] = Math.min(i + (word2.charAt(i) == word1.charAt(0) ? 0 : 1), res[i-1][0]+1);
		for (int i = 1; i < len2; i++)
			for (int j = 1; j < len1; j++)
				res[i][j] = Math.min(Math.min(res[i - 1][j], res[i][j - 1]) + 1,
						res[i - 1][j - 1] + (word2.charAt(i) == word1.charAt(j) ? 0 : 1));
//		for (int i = 0; i < len2; i++) {
//			for (int j = 0; j < len1; j++) {
//				System.out.printf("%-5s", res[i][j]);
//			}
//			System.out.println();
//		}
		return res[len2 - 1][len1 - 1];
	}

	public static void main(String[] args) {
		String[] word1 = { "abcicd","pneumonoultramicroscopicsilicovolcanoconiosis","horse", "intention", "a", "ab" };
		String[] word2 = { "bce","ultramicroscopically","ros", "execution", "ab", "a" };
//		System.out.println(minDistance(word1[1], word2[1]));
		for (int i = 0; i < word1.length; i++)
			System.out.println(minDistance(word1[i], word2[i]));
	}
}
