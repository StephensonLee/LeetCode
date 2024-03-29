package problems;
import java.util.*;

public class P51_1 {
    public static List<List<String>> solveNQueens(int n) {
        List<List<String>> answers = new ArrayList<>();
        permutation(0, n, new int[n], answers);
        return answers;
    }

    /**
     * 进行全排列，在全排列的过程中进行剪枝。
     * @param row 当前排列的行
     * @param n 列的数量
     * @param trace，前序计算中已经排列好的 trace
     * @param answers，答案收集器
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
     * 计算一个 position 是否是可能的答案。
     * @param row position 行
     * @param col position 列
     * @param trace 前面几行已经摆放好的皇后
     * 思路如下：前面的每个已经放置好的皇后，对其所在的 [行，列，45°和 -45°的两个斜线] 都有霸权，
     * 即：这些线条上都容不下其他皇后了。
     * 计算当前的 position(row, col) 是否和前面的几个皇后冲突的方式就是计算当前的 position 是否在其他皇后的
     * “行、列、45°对角线、-45°对角线” 这四个线条任意一个线条的霸权上。
     *  行、列都好判断，两个对角线怎么判断呢？有一个简单结论：如果两个坐标 position1， position2 在 45°对角线上冲突，那么
     *  (position1.row + position.col == position2.row + position2.col) == true，反之亦然，互为充要。
     *  所以 45° 冲突的计算方式是 row + col， 那么 -45° 冲突的计算方式就是 row - col。
     *  这个简单的公式，直接省掉了很多内存，一个长度为 n 的 trace 数组，就可以对后续可能的位置快速校验合法性，
     *  从而达到高效剪枝的目的。
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