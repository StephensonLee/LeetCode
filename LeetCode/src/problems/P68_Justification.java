package problems;
import java.util.*;

public class P68_Justification {
	public static List<String> fullJustify(String[] words, int maxWidth) {
		List<String> list =new ArrayList<String>();
		int len,blank,extra,start=0,end=0;
		while(end<words.length) {
			len=0;
			while (end<words.length&&(len+words[end].length()<=maxWidth)) {
				len+=words[end].length()+1;
				end++;
			}
			len-=end-start;
			blank=maxWidth-len;
			extra=0;
			if (end-start!=1) {
				extra= blank%(end-start-1);
				blank= blank/(end-start-1);
			}
			String cur="";
			String blk="";
			if (end!=words.length) {
				for (int i=0;i<blank;i++) {
					blk=blk.concat(" ");
				}
				if (end==start+1) {
					cur=cur.concat(words[start]);
					cur=cur.concat(blk);
					start++;
				} else {
					for (;start<end-1;start++) {
						cur=cur.concat(words[start]);
						cur=cur.concat(blk);
						if(extra-->0) cur=cur.concat(" ");
					}
					cur=cur.concat(words[start]);
					start++;
				}
				list.add(cur);
			} else {
				len+=end-start-1;
				blank=maxWidth-len;
				for (;start<end-1;start++) {
					cur=cur.concat(words[start]).concat(" ");
				}
				cur=cur.concat(words[start]);
				for (int i=0;i<blank;i++) {
					cur=cur.concat(" ");
				}
				list.add(cur);
			}
		}
		return list;
	}
	public static void main(String[] args) {

		String[] words= {"Listen","to","many,","speak","to","a","few."};
		int maxWidth =6;
		List<String> list = fullJustify(words,maxWidth);
		for (int i=0;i<list.size();i++) {
			System.out.println(list.get(i));
			System.out.println(list.get(i).length());
		}
	}
}
