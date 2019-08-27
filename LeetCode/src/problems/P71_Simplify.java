package problems;

import java.util.*;

public class P71_Simplify {
	public static String simplifyPath(String path) {
		List<String> list = new ArrayList<String>();
		int end = 0;
		String s = "";
		while (end < path.length()) {
			s = "";
			while (end < path.length() && path.charAt(end) == '/') {
				end++;
			}
			while (end < path.length() && path.charAt(end) != '/') {
				s += path.charAt(end);
				end++;
			}
			if (s.equals("..") ) {
				if (list.size() > 0) {
					list.remove(list.size() - 1);
				}
			} else if (s.equals(".")) {
			} else if (!s.equals("")){
				list.add(s);
			}
		}
		s = "";
		if (list.size() == 0) {
			return "/";
		}
		for (int i = 0; i < list.size(); i++) {
			s += '/' + list.get(i);
		}
		return s;
	}

	public static void main(String[] args) {
		String[] path = { "/..hidden", "/...", "/../","/home/", "/home//foo/", "/a/./b/../../c/", "/a/../../b/../c//.//",
				"/a//b////c/d//././/.." };
//		System.out.printf("%-20s", simplifyPath(path[2]));
		for (int i = 0; i < path.length; i++) {
			System.out.printf("%-50s", path[i]);
			System.out.printf("%-20s", simplifyPath(path[i]));
			System.out.println();
		}

	}
}
