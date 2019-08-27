package problems;
import java.util.*;

public class P49_Pro {
	public static List<List<String>> groupAnagrams(String[] strs) {
		Map<String,List<String>> map = new HashMap<String,List<String>>();
		for (String s:strs) {
			char[] temp = s.toCharArray();
			Arrays.sort(temp);
			String key=String.valueOf(temp);
			if (!map.containsKey(key)) {map.put(key, new ArrayList<String>());}
			map.get(key).add(s);
		}
		return new ArrayList<List<String>>(map.values());
    }
	public static void main(String[] args) {
		String[] strs= {"eat", "tea", "tan", "ate", "nat", "bat"};
		String s ="";
		String s1 ="aghggrsa";
		System.out.println(s.equals(s1));
		System.out.println(groupAnagrams(strs));
		
	}
}
