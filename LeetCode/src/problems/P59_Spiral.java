package problems;

public class P59_Spiral {
	public static int[][] generateMatrix(int n) {
		int[][] matrix = new int[n][n];
		int id=1;
		for (int i = 0; i < n/2; i++) {
			for (int j = i; j < n - 1 - i; j++) {
				matrix[i][j]=id++;
			}
			for (int j = i; j < n - i - 1; j++) {
				matrix[j][n - 1 - i]=id++;
			}
			for (int j = i; j < n - 1 - i; j++) {
				matrix[n - 1 - i][n - 1 - j]=id++;
			}
			for (int j = i; j < n - 1 - i; j++) {
				matrix[n - 1 - j][i]=id++;
			}
		}
		if (n%2==1) {
			matrix[n/2][n/2]=id++;
		}
		return matrix;
    }
	
	public static void main(String[] args) {
		int n=5;
		int[][] m= generateMatrix(n);
		for (int i=0;i<n;i++) {
			for (int j=0;j<n;j++) {
				System.out.print(m[i][j]);
				System.out.print(' ');
			}
			System.out.println();
		}
	}
}
