package problems;

public class P50_Pow {
	public static double myPow(double x, int n) {
		double y = 1;
        double f = x;
        int k = n;
        if (n < 0) {
            if ((n & 1) == 1) {
                y = 1 / x;
            }
            k = -(n / 2);
            f = (1 / x) * (1 / x);
        }
        while (k > 0) {
            if (k % 2 == 1) {
                y *= f;
            }
            k >>= 1;
            f *= f;
        }
        return y;
    }
	public static void main(String[] args) {
		double[] x= {0.00001,2.00000,2.10000,2.00000};
		int[] n= {2147483647,10,3,-2};
		for (int i=0;i<x.length;i++) {
			System.out.println(myPow(x[i],n[i]));
		}
	}
}
