import java.io.*;
import java.util.*;

public class Main {
    static int[][] board = new int[10][10];
    static int[] paper = {0, 5, 5, 5, 5, 5}; 
    static int min = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        for (int i = 0; i < 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 10; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, 0);
        System.out.println(min == Integer.MAX_VALUE ? -1 : min);
    }

    static void dfs(int x, int y, int used) {
        if (x >= 10) {
            min = Math.min(min, used);
            return;
        }

        if (y >= 10) {
            dfs(x + 1, 0, used);
            return;
        }

        if (board[x][y] == 1) {
            for (int size = 5; size >= 1; size--) {
                if (canAttach(x, y, size) && paper[size] > 0) {
                    attach(x, y, size, 0); 
                    paper[size]--;
                    dfs(x, y + 1, used + 1);
                    attach(x, y, size, 1); 
                    paper[size]++;
                }
            }
        } else {
            dfs(x, y + 1, used); 
        }
    }

    static boolean canAttach(int x, int y, int size) {
        if (x + size > 10 || y + size > 10) return false;

        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (board[i][j] != 1) return false;
            }
        }
        return true;
    }

    static void attach(int x, int y, int size, int val) {
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                board[i][j] = val;
            }
        }
    }
}
