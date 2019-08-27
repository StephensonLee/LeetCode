package problems;

public class P42_Trapping {
	public static int trap(int[] height) {
		int[] maxes1 = new int[height.length];
		int[] maxes2 = new int[height.length];
		int max1 = 0;
		int max2 = 0;
		int result = 0;
		for (int i = 0; i < height.length; i++) {
			if (max1 < height[i]) {
				max1 = height[i];
			}
			maxes1[i] = max1;
		}
		for (int i = height.length - 1; i >= 0; i--) {
			if (max2 < height[i]) {
				max2 = height[i];
			}
			maxes2[i] = max2;
		}
		for (int i = 0; i < height.length; i++) {
			if (maxes1[i] >= maxes2[i]) {
				result += maxes2[i] - height[i];
			} else {
				result += maxes1[i] - height[i];
			}
		}
		return result;
	}

	public static void main(String[] args) {
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trap(height));
	}
}
