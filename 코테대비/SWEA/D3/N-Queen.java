import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
class Solution {
    static int result;
 
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int i = 1; i <= T; i++) {
            int N = Integer.parseInt(br.readLine());
            result = 0;
            boolean[] visitedColumns = new boolean[N]; // 열 체크
            boolean[] visitedDiagonal1 = new boolean[2 * N]; // 왼쪽 대각선 체크
            boolean[] visitedDiagonal2 = new boolean[2 * N]; // 오른쪽 대각선 체크
            dfs(N, 0, visitedColumns, visitedDiagonal1, visitedDiagonal2);
            System.out.println("#" + i + " " + result);
        }
    }
 
    public static void dfs(int n, int row, boolean[] visitedColumns, boolean[] visitedDiagonal1, boolean[] visitedDiagonal2) {
        if (row == n) {
            result++;
            return;
        }
 
        for (int col = 0; col < n; col++) {
            // 현재 열과 대각선 체크
            if (!visitedColumns[col] && !visitedDiagonal1[row + col] && !visitedDiagonal2[row - col + n]) {
                // 방문 상태 업데이트
                visitedColumns[col] = true;
                visitedDiagonal1[row + col] = true;
                visitedDiagonal2[row - col + n] = true;
 
                // 다음 행으로 DFS
                dfs(n, row + 1, visitedColumns, visitedDiagonal1, visitedDiagonal2);
 
                // 방문 상태 되돌리기
                visitedColumns[col] = false;
                visitedDiagonal1[row + col] = false;
                visitedDiagonal2[row - col + n] = false;
            }
        }
    }
}