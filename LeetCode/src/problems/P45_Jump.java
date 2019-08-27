package problems;

public class P45_Jump {
	 public static int jump(int[] nums) {
	     int[] answer = new int[nums.length];
		 answer[nums.length-1]=0;
		 if (nums.length>1) {
			 for (int i=nums.length-2;i>=0;i--) {
				 if (nums[i]==0) {
					 answer[i]=nums.length;
				 }else {
					 int min=nums.length;
					 for (int j =1;j<=nums[i];j++) {
						 if (i+j<nums.length&&answer[i+j]<min) {
							 min=answer[i+j];
						 }
					 }
					 answer[i]=min+1;
				 }
			 }
		 }
		 for (int i=0;i<nums.length;i++) {
			 System.out.println(answer[i]);
		 }
		 
		 return answer[0];
	 }
	 
	 public static void main(String[] args) {
		 int[] nums = {2,0,3,1,1,4};
		 System.out.println(jump(nums));
		 
	 }
	 
}
