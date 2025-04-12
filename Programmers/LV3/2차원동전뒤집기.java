import java.util.*;

public class Solution {
    public int solution(int[][] beginning, int[][] target) {
        int n = beginning.length;
        int m = beginning[0].length;
        int min = Integer.MAX_VALUE;

        for (int rowMask = 0; rowMask < (1 << n); rowMask++) {
            int[][] copy = new int[n][m];

            for (int i = 0; i < n; i++)
                copy[i] = beginning[i].clone();

            for (int i = 0; i < n; i++) {
                if ((rowMask & (1 << i)) != 0) {
                    flipRow(copy, i, m);
                }
            }

            boolean[] colFlipped = new boolean[m];
            for (int j = 0; j < m; j++) {
                if (copy[0][j] != target[0][j]) {
                    colFlipped[j] = true;
                    flipCol(copy, j, n);
                }
            }

            if (isSame(copy, target, n, m)) {
                int rowCount = Integer.bitCount(rowMask);
                int colCount = 0;
                for (boolean flipped : colFlipped)
                    if (flipped) colCount++;
                min = Math.min(min, rowCount + colCount);
            }
        }

        return min == Integer.MAX_VALUE ? -1 : min;
    }

    private void flipRow(int[][] board, int row, int m) {
        for (int j = 0; j < m; j++) {
            board[row][j] ^= 1;
        }
    }

    private void flipCol(int[][] board, int col, int n) {
        for (int i = 0; i < n; i++) {
            board[i][col] ^= 1;
        }
    }

    private boolean isSame(int[][] a, int[][] b, int n, int m) {
        for (int i = 0; i < n; i++)
            for (int j = 0; j < m; j++)
                if (a[i][j] != b[i][j]) return false;
        return true;
    }
}
