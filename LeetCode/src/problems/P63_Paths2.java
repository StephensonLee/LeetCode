package problems;

public class P63_Paths2 {
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
		if (obstacleGrid[0][0]==1) return 0;
		obstacleGrid[0][0]=1;
		for (int i = 1; i < obstacleGrid.length; i++) {
			obstacleGrid[i][0] = obstacleGrid[i][0]==0?obstacleGrid[i-1][0]:0;
		}
		for (int i = 1; i < obstacleGrid[0].length; i++) {
			obstacleGrid[0][i] = obstacleGrid[0][i]==0?obstacleGrid[0][i-1]:0;
		}
		for (int i = 1; i < obstacleGrid.length; i++) {
			for (int j = 1; j < obstacleGrid[0].length; j++) {
				if (obstacleGrid[i][j] != 1) {
					obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
				} else {
					obstacleGrid[i][j] = 0;
				}
			}
		}
		return obstacleGrid[obstacleGrid.length - 1][obstacleGrid[0].length - 1];
	}

	public static void main(String[] args) {
		int[][] m = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		m = new int[][] { { 0 }, { 0} };
		System.out.println(uniquePathsWithObstacles(m));
	}
}
