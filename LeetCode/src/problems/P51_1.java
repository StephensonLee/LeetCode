package problems;
import java.util.*;

public class P51_1 {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> answers = new ArrayList<>();
        permutation(0, n, new int[n], answers);
        return answers;
    }

    /**
     * ����ȫ���У���ȫ���еĹ����н��м�֦��
     * @param row ��ǰ���е���
     * @param n �е�����
     * @param trace��ǰ��������Ѿ����кõ� trace
     * @param answers�����ռ���
     */
    private static void permutation(int row, int n, int[] trace, List<List<String>> answers) {
        for(int i = 0; i < n; i++) {
            if (check(row, i, trace)) {
                trace[row] = i;
                if (row != n - 1) {
                    permutation(row + 1, n, trace, answers);
                    continue;
                }
                List<String> answer = new ArrayList<>(trace.length);
                char[] r = new char[n];
                for (int j = 0; j < trace.length; j++) {
                    Arrays.fill(r, '.');
                    r[trace[j]] = 'Q';
                    answer.add(new String(r));
                }
                answers.add(answer);
            }
        }
    }

    /**
     * ����һ�� position �Ƿ��ǿ��ܵĴ𰸡�
     * @param row position ��
     * @param col position ��
     * @param trace ǰ�漸���Ѿ��ڷźõĻʺ�
     * ˼·���£�ǰ���ÿ���Ѿ����úõĻʺ󣬶������ڵ� [�У��У�45��� -45�������б��] ���а�Ȩ��
     * ������Щ�����϶��ݲ��������ʺ��ˡ�
     * ���㵱ǰ�� position(row, col) �Ƿ��ǰ��ļ����ʺ��ͻ�ķ�ʽ���Ǽ��㵱ǰ�� position �Ƿ��������ʺ��
     * ���С��С�45��Խ��ߡ�-45��Խ��ߡ� ���ĸ���������һ�������İ�Ȩ�ϡ�
     *  �С��ж����жϣ������Խ�����ô�ж��أ���һ���򵥽��ۣ������������ position1�� position2 �� 45��Խ����ϳ�ͻ����ô
     *  (position1.row + position.col == position2.row + position2.col) == true����֮��Ȼ����Ϊ��Ҫ��
     *  ���� 45�� ��ͻ�ļ��㷽ʽ�� row + col�� ��ô -45�� ��ͻ�ļ��㷽ʽ���� row - col��
     *  ����򵥵Ĺ�ʽ��ֱ��ʡ���˺ܶ��ڴ棬һ������Ϊ n �� trace ���飬�Ϳ��ԶԺ������ܵ�λ�ÿ���У��Ϸ��ԣ�
     *  �Ӷ��ﵽ��Ч��֦��Ŀ�ġ�
     */
    private static boolean check(int row, int col, int[] trace) {
        for (int i = 0; i < row; i++) {
            int pos = trace[i];
            int idx1 = col + row;
            int idx2 = col - row;
            if (pos == col || (pos + i) == idx1 || (pos - i) == idx2) {
                return false;
            }
        }
        return true;
    }
	public static void main(String[] args) {
		int i =15;
		System.out.println(solveNQueens(i));
	}
}