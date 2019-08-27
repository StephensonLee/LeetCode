package problems;

import java.util.*;

public class P60_Permutation {
	public static String getPermutation(int n, int k) {
		char[] s = new char[n];
		List<Character> list = new ArrayList<Character>();
		for (int i = 0; i < n; i++) {
			list.add((char) (i + 49));
		}
		k--;
		for (int i = 0; i < n; i++) {
			int num = f(n - 1 - i);
			int order = k / num;
			k = k % num;
			s[i] = list.get(order);
			list.remove(order);
		}
		return new String(s);
	}

	public static int f(int n) {
		int ans = 1;
		for (int i = 2; i <= n; i++)
			ans *= i;
		return ans;
	}

	public static void main(String[] args) {
		int n = 2;
		int k = 2;
		System.out.println(f(n));
		System.out.println(getPermutation(n, k));
	}
}
