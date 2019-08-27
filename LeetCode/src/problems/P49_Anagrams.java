package problems;
import java.util.*;

public class P49_Anagrams {
	public static List<List<String>> groupAnagrams(String[] strs) {
		List<List<String>> list = new ArrayList<List<String>>();
		String[] strs_fmt = new String[strs.length];
		for (int i =0;i<strs.length;i++) {
			strs_fmt[i]=format(strs[i]);
		}
        for (int i=0;i<strs.length;i++) {
        	if (strs_fmt[i]==null) {continue;}
        	else {
        		List<String> cur = new ArrayList<String>();
        		cur.add(strs[i]);
        		for (int j=i+1;j<strs.length;j++) {
        			if (strs_fmt[j]!=null&&strs_fmt[j].equals(strs_fmt[i])) {
        				cur.add(strs[j]);
        				strs_fmt[j]=null;
        			}
        		}
        		list.add(cur);
        	}
        }
		return list;
    }
	public static String format (String s) {
		char[] temp=s.toCharArray();
		Arrays.sort(temp);
		return String.valueOf(temp);
	}
	public static void main(String[] args) {
		String[] strs= {"eat", "tea", "tan", "ate", "nat", "bat"};
		String s ="";
		String s1 ="aghggrsa";
		System.out.println(s.equals(s1));
		System.out.println(groupAnagrams(strs));
		
	}
}
