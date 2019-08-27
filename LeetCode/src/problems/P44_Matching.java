package problems;

public class P44_Matching {
	public static boolean isMatch(String s, String p) {
		while (p.length() > 1 && p.charAt(0) == '*' && p.charAt(1) == '*') {
			p = p.substring(1);
		}
		if (s.length() == 0) {
			if (p.length() == 0) {
				return true;
			}
			while (p.length() > 0 && p.charAt(0) == '*') {
				p = p.substring(1);
			}
			if (p.length() == 0) {
				return true;
			} else {
				return false;
			}
		}
		if (p.length() == 0 && s.length() != 0) {
			return false;
		}
		if (p.charAt(0) == '?') {
			return isMatch(s.substring(1), p.substring(1));
		} else if (p.charAt(0) == '*') {
			for (int i = 0; i <= s.length(); i++) {
				if (isMatch(s.substring(i), p.substring(1)) == true) {
					return true;
				}
			}
			return false;
		} else if (p.charAt(0) == s.charAt(0)) {
			return isMatch(s.substring(1), p.substring(1));
		} else {
			return false;
		}
	}

	public static void main(String[] args) {
		String[] s = { "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "aa", "aa", "cb", "adceb", "acdcb" };
		String[] p = { "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb", "a", "*", "?a", "*a*b", "a*c?b" };
		for (int i = 0; i < s.length; i++) {
			System.out.println(isMatch(s[i], p[i]));
		}
	}
}
