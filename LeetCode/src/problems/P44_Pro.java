package problems;

import java.util.*;

public class P44_Pro {
	public static boolean isMatch(String s, String p) {
		while (s.length() > 0 && p.length() > 0 && p.charAt(0) != '*') {
			if (p.charAt(0) == '?' || p.charAt(0) == s.charAt(0)) {
				s = s.substring(1);
				p = p.substring(1);
			} else {
				return false;
			}
		}
		while (p.length() > 1 && p.charAt(0) == '*' && p.charAt(1) == '*') {
			p = p.substring(1);
		}
		if (s.length() > 0 && p.length() > 1) {
			int i = 1;
			for (; i < p.length(); i++) {
				if (p.charAt(i) == '*') {
					break;
				}
			}
			String cur = p.substring(1, i);
			p = p.substring(i);

			ArrayList<Integer> list = new ArrayList<Integer>();
			if (cur.length() > 0) {
				list = getIndex(s, cur);
			}
			if (!list.isEmpty()) {
				Iterator<Integer> it = list.iterator();
				while (it.hasNext()) {
					if (isMatch(s.substring(it.next() + cur.length()), p)) {
						return true;
					}
				}
				return false;
			} else
				return false;
		} else if (s.length() == 0) {
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
		} else if (p.length() == 1) {
			return true;
		} else {
			return false;
		}
	}

	public static ArrayList<Integer> getIndex(String s, String p) {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i <= s.length() - p.length(); i++) {
			boolean b = true;
			for (int j = 0; j < p.length(); j++) {
				if (p.charAt(j) == '?')
					continue;
				else if (p.charAt(j) == s.charAt(i + j))
					continue;
				else {
					b = false;
					break;
				}
			}
			if (b == true) {
				list.add(i);
			}
		}
		return list;
	}

	public static void main(String[] args) {
		String[] s = { "abbabaaabbabbaababbabbbbbabbbabbbabaaaaababababbbabababaabbababaabbbbbbaaaabababbbaabbbbaabbbbababababbaabbaababaabbbababababbbbaaabbbbbabaaaabbababbbbaababaabbababbbbbababbbabaaaaaaaabbbbbaabaaababaaaabb", "aa", "aa", "cb", "adceb", "acdcb" };
		String[] p = { "**aa*****ba*a*bb**aa*ab****a*aaaaaa***a*aaaa**bbabb*b*b**aaaaaaaaa*a********ba*bbb***a*ba*bb*bb**a*b*bb", "a", "*", "?a", "*a*b", "a*c?b" };
		for (int i = 0; i < s.length; i++) {
			System.out.println(isMatch(s[i], p[i]));
		}
	}
}
