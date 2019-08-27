package problems;

public class P70_Climbing {
	public static int climbStairs(int n) {
        int a1=1,a2=1,temp;        
        for (int i=0;i<n-1;i++) {
        	temp=a2;
        	a2=a1+a2;
        	a1=temp;
        }
        return a2;
    }
	public static void main(String[] args) {
		for (int i=1;i<50;i++) {
			System.out.println(climbStairs(i));
		}
	}
}
