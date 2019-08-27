package problems;

public class P48_Rotate {
	public static void rotate(int[][] matrix) {
		int len = matrix.length;
        for (int i=0;i<len;i++) {
        	for (int j=i;j<len;j++) {
        		int cur = matrix[i][j];
        		matrix[i][j]=matrix[j][i];
        		matrix[j][i]=cur;
        	}
        }
		
        for (int i=0;i<len;i++) {
        	for (int j=0;j<len/2;j++) {
        		int cur = matrix[i][j];
        		matrix[i][j]=matrix[i][len-1-j];
        		matrix[i][len-1-j]=cur;
        	}
        }
		
		
    }
	public static void main(String[] args) {
		int[][] matrix= {{1,2,3},{4,5,6},{7,8,9}};
		rotate(matrix);
		for (int i=0;i<matrix.length;i++) {
			for (int j=0;j<matrix.length;j++) {
				System.out.print(matrix[i][j]+" ");
			}
			System.out.println();
		}
	}
}
