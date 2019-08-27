package problems;

public class P75_Colors {
	public static void sortColors(int[] nums)
    {
        int first = 0, last = nums.length-1, current = 0;
        while(current <= last)
        {
            if(nums[current] == 0) exchange(nums, first++, current++);
            else if(nums[current] == 2) exchange(nums, last--, current);
            else current++;
        }
    }
    
    private static void exchange(int[] nums, int i, int j)
    {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

	public static void main(String[] args) {
		int[][] matrix = { { 2, 0, 2, 1, 1, 0 }, { 1, 2, 0 } };
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
			sortColors(matrix[i]);
			for (int j = 0; j < matrix[i].length; j++) {
				System.out.print(matrix[i][j] + "\t");
			}
			System.out.println();
			System.out.println();
		}
	}
}
