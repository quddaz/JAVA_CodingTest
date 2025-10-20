import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[][] board;
    static int S, X, Y;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static class Virus implements Comparable<Virus> {
        int num, time, x, y;
        public Virus(int num, int time, int x, int y) {
            this.num = num;
            this.time = time;
            this.x = x;
            this.y = y;
        }
        @Override
        public int compareTo(Virus o) {
            return this.num - o.num; 
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        board = new int[N][N];
        List<Virus> viruses = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                if (board[i][j] != 0) {
                    viruses.add(new Virus(board[i][j], 0, i, j));
                }
            }
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken()) - 1; 
        Y = Integer.parseInt(st.nextToken()) - 1;

        Collections.sort(viruses);

        Queue<Virus> q = new LinkedList<>();
        q.addAll(viruses);

        while (!q.isEmpty()) {
            Virus v = q.poll();
            if (v.time == S) break; 
            for (int dir = 0; dir < 4; dir++) {
                int nx = v.x + dx[dir];
                int ny = v.y + dy[dir];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
                if (board[nx][ny] == 0) {
                    board[nx][ny] = v.num;
                    q.add(new Virus(v.num, v.time + 1, nx, ny));
                }
            }
        }

        System.out.println(board[X][Y]);
    }
}
