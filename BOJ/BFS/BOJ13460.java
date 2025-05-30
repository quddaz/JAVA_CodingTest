import java.io.*;
import java.util.*;

public class Main {
    static class State {
        int rx, ry, bx, by, depth;

        State(int rx, int ry, int bx, int by, int depth) {
            this.rx = rx;
            this.ry = ry;
            this.bx = bx;
            this.by = by;
            this.depth = depth;
        }
    }

    static int N, M;
    static char[][] board;
    static boolean[][][][] visited;
    static int[] dx = {-1, 1, 0, 0}; // 상 하 좌 우
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new char[N][M];
        visited = new boolean[N][M][N][M];

        int rx = 0, ry = 0, bx = 0, by = 0;

        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = line.charAt(j);
                if (board[i][j] == 'R') {
                    rx = i;
                    ry = j;
                }
                if (board[i][j] == 'B') {
                    bx = i;
                    by = j;
                }
            }
        }

        System.out.println(bfs(rx, ry, bx, by));
    }

    static int bfs(int rx, int ry, int bx, int by) {
        Queue<State> queue = new LinkedList<>();
        queue.add(new State(rx, ry, bx, by, 0));
        visited[rx][ry][bx][by] = true;

        while (!queue.isEmpty()) {
            State cur = queue.poll();

            if (cur.depth >= 10) return -1;

            for (int d = 0; d < 4; d++) {
                int[] nextRed = move(cur.rx, cur.ry, dx[d], dy[d]);
                int[] nextBlue = move(cur.bx, cur.by, dx[d], dy[d]);

                if (board[nextBlue[0]][nextBlue[1]] == 'O') continue; 
                if (board[nextRed[0]][nextRed[1]] == 'O') return cur.depth + 1; 

                if (nextRed[0] == nextBlue[0] && nextRed[1] == nextBlue[1]) {
                    if (nextRed[2] > nextBlue[2]) {
                        nextRed[0] -= dx[d];
                        nextRed[1] -= dy[d];
                    } else {
                        nextBlue[0] -= dx[d];
                        nextBlue[1] -= dy[d];
                    }
                }

                if (!visited[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]]) {
                    visited[nextRed[0]][nextRed[1]][nextBlue[0]][nextBlue[1]] = true;
                    queue.add(new State(nextRed[0], nextRed[1], nextBlue[0], nextBlue[1], cur.depth + 1));
                }
            }
        }

        return -1;
    }

    static int[] move(int x, int y, int dx, int dy) {
        int dist = 0;
        while (true) {
            if (board[x + dx][y + dy] == '#' || board[x][y] == 'O') break;
            x += dx;
            y += dy;
            dist++;
        }
        return new int[]{x, y, dist};
    }
}
