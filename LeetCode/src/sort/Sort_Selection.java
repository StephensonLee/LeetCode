package sort;

public class Sort_Selection {
    public void selectionSort(int[] array) {
        int temp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j <= array.length - 1; j++) {// ��i���͵�j���Ƚ�j����ȡ�����һλ������Ҫ��j<=array.length-1
                if (array[i] > array[j]) {// ע���ð�����������������i��j�Ƚϡ�
                    temp = array[i];
                    array[i] = array[j];
                    array[j] = temp;
                }
            }
            // ��ӡÿ��������
            for (int m = 0; m <= array.length - 1; m++) {
                System.out.print(array[m] + "\t");
            }
            System.out.println();
        }
    }
  
    public static void main(String[] args) {
        Sort_Selection selectionSort = new Sort_Selection();
        int[] array = { 5, 69, 12, 3, 56, 789, 2, 5648, 23 };
        selectionSort.selectionSort(array);
        for (int m = 0; m <= array.length - 1; m++) {
            System.out.print(array[m] + "\t");
        }
    }
}
