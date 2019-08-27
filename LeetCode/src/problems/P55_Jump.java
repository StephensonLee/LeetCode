package problems;

public class P55_Jump {
	public static boolean canJump(int[] nums) {
		boolean result =true;
		if (nums.length==1) return result;
		for (int i=0;i<nums.length-1;i++) {
			if (nums[i]==0) {
		        boolean b=false;
				for (int j=i;j>=0;j--) {
					if (nums[j]>i-j) {
						b=true;
						break;
					}
				}
				if (!b) return b;
			}
		} 
		return result;
    }
	
	public static void main(String[] args) {
		int[] nums= {3,2,1,0,4};
		
		System.out.println(canJump(nums));
	}
}
