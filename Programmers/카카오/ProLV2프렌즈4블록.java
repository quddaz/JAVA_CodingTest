import java.util.*;

class Solution {
    public int solution(int m, int n, String[] board) {
        char[][] map = new char[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].toCharArray();
        }
        
        int answer = 0;
        while (true) {
            boolean[][] check = new boolean[m][n];
            int cnt = 0;

            for (int i = 0; i < m - 1; i++) {
                for (int j = 0; j < n - 1; j++) {
                    char c = map[i][j];
                    if (c == '.') continue;
                    if (map[i][j+1] == c && map[i+1][j] == c && map[i+1][j+1] == c) {
                        check[i][j] = check[i][j+1] = check[i+1][j] = check[i+1][j+1] = true;
                    }
                }
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (check[i][j]) {
                        map[i][j] = '.';
                        cnt++;
                    }
                }
            }

            if (cnt == 0) break; 
            answer += cnt;

            for (int j = 0; j < n; j++) {
                int idx = m - 1;
                for (int i = m - 1; i >= 0; i--) {
                    if (map[i][j] != '.') {
                        map[idx][j] = map[i][j];
                        if (idx != i) map[i][j] = '.';
                        idx--;
                    }
                }
            }
        }
        return answer;
    }
}
