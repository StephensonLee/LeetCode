package sort;

public class Sort_Quick {
	public int partition(int[] sortArray, int start, int end) {
		int key = sortArray[start];// �տ�ʼ�Ե�һ����Ϊ��־����
		while (start < end) {
			while (start < end && sortArray[end] >= key)
				end--;// �Ӻ��濪ʼ�ң��ҵ���keyֵС����Ϊֹ
			sortArray[start] = sortArray[end];// �������ŵ�keyֵ�����
			while (start < end && sortArray[start] <= key)
				start++;// ��ǰ�濪ʼ�ң��ҵ���keyֵ�����Ϊֹ
			sortArray[end] = sortArray[start];// �������ŵ�keyֵ���ұ�
//			for (int i = 0; i <= sortArray.length - 1; i++) {
//				System.out.print(sortArray[i] + "\t");
//			}
//			System.out.println();
		}
		sortArray[start] = key;// ��keyֵ��䵽lowλ�ã��´�������keyֵ
		// ��ӡÿ��������
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