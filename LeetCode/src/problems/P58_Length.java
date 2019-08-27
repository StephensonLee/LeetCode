package problems;

public class P58_Length {
	public static int lengthOfLastWord(String s) {
		if (s.length()==0) return 0;
		int count =0;
		int index=s.length()-1;
		while (index>=0&&s.charAt(index)==' ') index--;
		if (index==-1) return 0;
		while (index>=0&&s.charAt(index)!=' ') {
			count++;
			index--;
		}
		return count;
	}
	public static void main(String[] args) {
		String s="Hello World";
		System.out.println(lengthOfLastWord(s));
	}
}
