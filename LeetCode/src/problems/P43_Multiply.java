package problems;

public class P43_Multiply {
	public static String multiply(String num1, String num2) {
		String results = "";
		int[] nums1 = convert(num1);
		int[] nums2 = convert(num2);
		if (nums1.length == 1 && nums1[0] == 0) {
			return "0";
		}
		if (nums2.length == 1 && nums2[0] == 0) {
			return "0";
		}
		int[] res = new int[num1.length() + num2.length()];
		int carry = 0;
		int cur;
		for (int i = 0; i < num1.length() + num2.length(); i++) {
			cur = 0;
			for (int j = 0; j <= i; j++) {
				if (j < nums1.length && (i - j) < nums2.length) {
					cur += nums1[j] * nums2[i - j];
				}
			}
			res[i] = (cur + carry) % 10;
			carry = (cur + carry) / 10;
		}
		if (res[num1.length() + num2.length() - 1] != 0) {
			results += (char) (res[num1.length() + num2.length() - 1] + 48);
		}
		for (int i = num1.length() + num2.length() - 2; i >= 0; i--) {
			results += (char) (res[i] + 48);
		}
		return results;
	}

	public static int[] convert(String num) {
		int[] results = new int[num.length()];
		int len = num.length();
		for (int i = 0; i < len; i++) {
			results[i] = num.charAt(len - 1 - i) - 48;
		}
		return results;

	}

	public static void main(String[] args) {
		String num1 = "33";
		String num2 = "0";
		System.out.println(multiply(num1, num2));
	}
}
