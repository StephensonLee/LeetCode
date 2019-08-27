package sort;

public class Sort_Quick {
	public int partition(int[] sortArray, int start, int end) {
		int key = sortArray[start];// 刚开始以第一个数为标志数据
		while (start < end) {
			while (start < end && sortArray[end] >= key)
				end--;// 从后面开始找，找到比key值小的数为止
			sortArray[start] = sortArray[end];// 将该数放到key值的左边
			while (start < end && sortArray[start] <= key)
				start++;// 从前面开始找，找到比key值大的数为止
			sortArray[end] = sortArray[start];// 将该数放到key值的右边
//			for (int i = 0; i <= sortArray.length - 1; i++) {
//				System.out.print(sortArray[i] + "\t");
//			}
//			System.out.println();
		}
		sortArray[start] = key;// 把key值填充到low位置，下次重新找key值
		// 打印每次排序结果
		for (int i = 0; i <= sortArray.length - 1; i++) {
			System.out.print(sortArray[i] + "\t");
		}
		System.out.println();
		return start;
	}

	public void sort(int[] sortArray, int start, int end) {
		if (start < end) {
			int result = partition(sortArray, start, end);
			sort(sortArray, start, result - 1);
			sort(sortArray, result + 1, end);
		}
	}

	public static void main(String[] args) {
		Sort_Quick quickSort = new Sort_Quick();
		int[] array = { 5, 69, 12, 3, 56, 789, 2, 5648, 23 };
		for (int i = 0; i <= array.length - 1; i++) {
			System.out.print(array[i] + "\t");
		}
		System.out.println();
		quickSort.sort(array, 0, 8);
		for (int i = 0; i <= array.length - 1; i++) {
			System.out.print(array[i] + "\t");
		}
	}
}