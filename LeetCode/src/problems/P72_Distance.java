package problems;

public class P72_Distance {
	public static int minDistance(String word1, String word2) {
		return order(word1.toCharArray(),word2.toCharArray());
	}

	public static int order(char[] c1, char[] c2) {
		if (contains(c1,c2))
			return c1.length-c2.length;
		else {
			int min=c1.length+c2.length;
			for (int i = 0; i < c2.length; i++) {
				if (c2[i]!='?') {
					char[] cur =c2.clone();
					cur[i]='?';
					if (contains(c1,cur)) {
						return c1.length-cur.length+1;
					} else {
						int count=order(c1,cur)+1;
						if (count<min) {
							min=count;
						}
					}
				}
			}
			return  min;
		}
	}

	public static boolean contains(char[] c1, char[] c2) {
		int id1 = 0;
		int id2 = 0;
		while (id1 < c1.length && id2 < c2.length) {
			while (c2[id2]=='?') {id1++;id2++;}
			while (id1 < c1.length && c1[id1] != c2[id2]) {
				id1++;
			}
			id1++;
			id2++;
		}
		if (id2 == c2.length && id1 <= c1.length)
			return true;
		else
			return false;
	}

	public static void main(String[] args) {
		String word1 = "intention";
		String word2 = "???????on";
		System.out.println(contains(word1.toCharArray(), word2.toCharArray()));
		System.out.println(order(word1.toCharArray(), word2.toCharArray()));
	}
}
