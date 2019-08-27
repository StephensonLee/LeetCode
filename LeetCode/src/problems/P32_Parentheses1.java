package problems;

public class P32_Parentheses1 {
	public static int longest(String s) {
		int dp[] = new int[s.length()];
		for (int i = 1; i < s.length(); i++) {
			if (s.charAt(i) == ')' && s.charAt(i - 1) == '(') {
				if (i == 1) {
					dp[1] = 2;
				} else {
					dp[i] = dp[i - 2] + 2;
				}
			} else if (s.charAt(i) == ')' && s.charAt(i - 1) == ')') {
				if (i == 1) {
					dp[1] = 0;
				} else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					if (i - dp[i - 1] - 1 == 0) {
						dp[i] = dp[i - 1] + 2;
					} else {
						dp[i] = dp[i - 1] + dp[i - dp[i - 1] - 2] + 2;
					}
				}
			} else {
				dp[i] = 0;
			}
		}
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			max = Math.max(max, dp[i]);
		}
		return (max);
	}

	public static void main(String[] args) {
		String s = "(()())";
		System.out.println(longest(s));
	}
}
