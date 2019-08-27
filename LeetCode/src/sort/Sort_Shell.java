package sort;

public class Sort_Shell {
    public void shellSort(int[] array, int n) {
        int i, j, gap;
        int temp;
        for (gap = n / 2; gap > 0; gap /= 2) {// ����gap��С
            for (i = gap; i < n; i++) {// �����ݽ��з���
                for (j = i - gap; j >= 0 && array[j] > array[j + gap]; j -= gap) {// ��ÿ�����ݽ��в�������
                    temp = array[j];
                    array[j] = array[j + gap];
                    array[j + gap] = temp;
                }
                // ��ӡÿ��������
                for (int m = 0; m <= array.length - 1; m++) {
                    System.out.print(array[m] + "\t");
                }
                System.out.println();
            }
        }
    }
  
    public static void main(String[] args) {
        Sort_Shell shellSort = new Sort_Shell();
        int[] array = { 5, 69, 12, 3, 56, 789, 2, 5648, 23 };
        shellSort.shellSort(array, array.length);// ע��Ϊ����ĸ���
        for (int m = 0; m <= array.length - 1; m++) {
            System.out.print(array[m] + "\t");
        }
    }
}