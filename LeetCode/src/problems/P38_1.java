package problems;

public class P38_1 {

	public static String countAndSay(int n) {
		if (n == 1)
			return "1";
		if (n == 2)
			return "11";
		else {
			String pre = countAndSay(n - 1);
			int len = pre.length();
			StringBuilder stringBuilder = new StringBuilder();
			for (int i = 0; i < len; i++) {
				if (i == len - 1 && pre.charAt(len - 2) != pre.charAt(len - 1))
					stringBuilder.append(1).append(pre.charAt(len - 1));
				for (int j = i + 1; j < len; j++) {
					if (pre.charAt(i) != pre.charAt(j)) {
						stringBuilder.append(j - i).append(pre.charAt(i));
						i = j;
					}
					if (pre.charAt(i) == pre.charAt(j) && j == len - 1)
						stringBuilder.append(j - i + 1).append(pre.charAt(i));
				}
			}
			return stringBuilder.toString();
		}
	}
	public static void main(String[] args) {
//		int i = 7;
//		String s = "1211";
		for (int i=1;i<30;i++) {
			System.out.println(countAndSay(i));
		}

	}
}
