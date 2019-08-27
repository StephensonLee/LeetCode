package problems;

public class P45_Pro {
	 public static int jump(int[] nums) {
	        int jumps = 0, rangeStart = 0, rangeEnd = 0;
	        while(rangeEnd < nums.length-1) {
	            jumps++;
	            int previousEnd = rangeEnd;
	            for(int i = rangeStart; i <= previousEnd; i++) {
	                if(nums[i] + i > rangeEnd) {
	                    rangeEnd = nums[i] + i;
	                }
	            }
	            rangeStart = previousEnd + 1;
	        }
	        return jumps;
	    }
	 public static void main(String[] args) {
		 int[] nums = {2,0,3,1,1,4,3,2,1,4};
		 System.out.println(jump(nums));
		 
	 }
}
