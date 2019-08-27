package problems;

public class P44_Answer {
	public static boolean isMatch(String s, String p) {

		boolean dp[][] = new boolean[s.length() + 1][p.length() + 1];
		dp[0][0] = true;

		for (int i = 1; i <= p.length(); i++)
			if (p.charAt(i - 1) == '*')
				dp[0][i] = dp[0][i - 1];

		for (int i = 1; i <= s.length(); i++) {
			for (int j = 1; j <= p.length(); j++) {
				if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '?') {
					dp[i][j] = dp[i - 1][j - 1];
				} else if (p.charAt(j - 1) == '*') {
					dp[i][j] = dp[i - 1][j] || dp[i][j - 1];
				}
			}
		}

		return dp[s.length()][p.length()];
	}
	public static void main(String[] args) {
		String[] s = { "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "aa", "aa", "cb", "adceb", "acdcb" };
		String[] p = { "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb", "a", "*", "?a", "*a*b", "a*c?b" };
		for (int i = 0; i < s.length; i++) {
			System.out.println(isMatch(s[i], p[i]));
		}
	}
}
