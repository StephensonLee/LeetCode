package problems;

public class P66_Plus {
	public static int[] plusOne(int[] digits) {
        int len =digits.length-1;
        while (len>=0&&digits[len]==9) {
        	digits[len--]=0;
        }
        if (len>=0) {
    		digits[len]++;
    		return digits;
        } else {
        	int[] ans =new int[digits.length+1];
        	ans[0]=1;
        	return ans;
        }
    }
	public static void main(String[] args) {
		int[] nums= {1,2,3};

		int[] out=plusOne(nums);
		for (int i=0;i<out.length;i++) {
			System.out.println(out[i]);
		}
	}
}
