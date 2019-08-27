package problems;

public class P73_Zeros {
	public static void setZeroes(int[][] matrix) {
        int[] id1 = new int[matrix.length];
        int[] id2 = new int[matrix[0].length];
		for (int i=0;i<matrix.length;i++) {
        	for (int j=0;j<matrix[i].length;j++) {
        		if (matrix[i][j]==0) {
        			id1[i]=1;
        			id2[j]=1;
        		}
        	}
        }
		for (int i=0;i<matrix.length;i++) {
			for (int j=0;j<matrix[i].length;j++) {
				if (id1[i]==1||id2[j]==1) {
        			matrix[i][j]=0;
        		}
        	}
        }
    }

	public static void main(String[] args) {
		int[][][] matrix= {
				 {{1,1,1},{1,0,1},{1,1,1}},
				 {{0,1,2,0},{3,4,5,2},{1,3,1,5}},
//				 {{0,0,0,0},{0,4,5,0},{0,3,1,0}}
		};
		for (int i=0;i<matrix.length;i++) {
			for (int j=0;j<matrix[i].length;j++) {
				for (int k=0;k<matrix[i][j].length;k++) {
					System.out.printf("%-5s", matrix[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
			setZeroes(matrix[i]);
			for (int j=0;j<matrix[i].length;j++) {
				for (int k=0;k<matrix[i][j].length;k++) {
					System.out.printf("%-5s", matrix[i][j][k]);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
