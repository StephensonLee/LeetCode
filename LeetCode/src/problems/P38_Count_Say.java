package problems;

public class P38_Count_Say {
	public static String countAndSay(int n) {
		String cur = "1";
		for (int i = 0; i < n-1; i++) {
			cur = recursion(cur);
		}
		return cur;
	}

	public static String recursion(String s) {
		String sout = "";
		char cur=s.charAt(0);
		int count=1;
		s=s.substring(1);
		while (s.length()>0) {
			if (cur!=s.charAt(0)) {
				sout+=(char) (count + 48);
				sout+=cur;
				cur=s.charAt(0);
				count =1;
				s=s.substring(1);
			} else {
				count++;
				s=s.substring(1);
			}
		}
		sout+=(char) (count + 48);
		sout+=cur;
		return sout;
	}

	public static void main(String[] args) {
//		int i = 7;
//		String s = "1211";
		for (int i=1;i<30;i++) {
			System.out.println(countAndSay(i));
		}

	}
}
