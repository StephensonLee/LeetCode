package problems;
import java.util.*;

public class P71_Stack {
	public static String simplifyPath(String path) {
		Stack<String> stk=new Stack<String>();
		String[] strs=path.split("/");
		for (int i=0;i<strs.length;i++) {
			if (strs[i].equals("..") ) {
				if (!stk.isEmpty()) {
					stk.pop();
				}
			} else if (strs[i].equals(".")) {
			} else if (!strs[i].equals("")){
				stk.push(strs[i]);
			}
		}
		if (stk.isEmpty()) return "/";
		StringBuilder ss = new StringBuilder("/");
		while(!stk.isEmpty()) {
			ss.insert(0,"/"+stk.pop());
		}
		String s=ss.toString();
		return s.substring(0, s.length()-1);
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
