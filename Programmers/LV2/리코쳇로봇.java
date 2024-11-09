import java.util.*;

class Solution {
    static int dx[] = {-1, 0, 1, 0}; // 상, 우, 하, 좌
    static int dy[] = {0, 1, 0, -1};
    static int lengthX;
    static int lengthY; 

    public int solution(String[] board) {
        lengthX = board.length;
        lengthY = board[0].length();
        int map[][] = new int[lengthX][lengthY];
        int startX = 0;
        int startY = 0;

    // 보드에서 시작점 찾기
    for (int i = 0; i < lengthX; i++) {
        String str = board[i];
        for (int j = 0; j < lengthY; j++) {
            char target = str.charAt(j);
            if (target == '.') {
                map[i][j] = 0;
            } else if (target == 'D') {
                map[i][j] = 1;
            } else if (target == 'G') {
                map[i][j] = 2;
            } else if (target == 'R') {
                startX = i;
                startY = j;
                System.out.println("R found at: (" + startX + ", " + startY + ")");
            }
        }
    }
        return bfs(map, startX, startY);
    }

    public static int bfs(int[][] map, int startX, int startY) {
        Queue<int[]> q = new LinkedList<>();
        boolean visited[][] = new boolean[lengthX][lengthY];
        q.add(new int[]{startX, startY, 0});
        visited[startX][startY] = true;

        while (!q.isEmpty()) {
            int arr[] = q.poll();
            int x = arr[0];
            int y = arr[1];
            int count = arr[2];

            if (map[x][y] == 2)
                return count;

            for (int i = 0; i < dx.length; i++) {
                int move_x = x;
                int move_y = y;

                while (move_x + dx[i] >= 0 && move_x + dx[i] < lengthX && move_y + dy[i] >= 0 && move_y + dy[i] < lengthY && map[move_x + dx[i]][move_y + dy[i]] != 1) {
                    move_x += dx[i];
                    move_y += dy[i];
                }
                if (!visited[move_x][move_y]) {
                    visited[move_x][move_y] = true;
                    q.add(new int[]{move_x, move_y, count + 1});
                }
            }
        }

        return -1;
    }
}
