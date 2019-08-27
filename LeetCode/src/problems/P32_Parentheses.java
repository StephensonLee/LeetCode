package problems;

import java.util.*;

public class P32_Parentheses {
	public boolean match(String s) {
		Stack<Character> stk = new Stack<Character>();
		for (int i = 0; i < s.length(); i = i + 1) {
			if (s.charAt(i) == '(') {
				stk.push('(');
			} else if (!stk.isEmpty() && s.charAt(i) == ')') {
				stk.pop();
			} else {
				return false;
			}
		}
		return stk.isEmpty();
	}

	public int longest(String s) {
		int max = 0;
		for (int i = 0; i < s.length(); i++) {
			for (int j = i + 2; j <= s.length(); j += 2) {
				if (match(s.substring(i, j)) && max < j - i) {
					max = j - i;
					System.out.println(i);
					System.out.println(j);
				}
			}
		}
		return max;
	}

	public static void main(String[] args) {
		String s = "()()()";
		int l;

		P32_Parentheses p = new P32_Parentheses();
		l = p.longest(s);
		System.out.println(l);

	}
}
