import java.util.*;
import java.io.*;

public class Main {
    static int N, M, x, y, K;
    static int[][] map;
    static int[] dice = new int[6]; // 0:top, 1:bottom, 2:north, 3:south, 4:west, 5:east
    static int[] dx = {0, 0, 0, -1, 1}; // 동서북남
    static int[] dy = {0, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < K; i++) {
            int dir = Integer.parseInt(st.nextToken());
            int nx = x + dx[dir];
            int ny = y + dy[dir];

            if (nx < 0 || ny < 0 || nx >= N || ny >= M) continue;

            rollDice(dir);
            x = nx;
            y = ny;

            if (map[x][y] == 0) {
                map[x][y] = dice[1]; // 바닥 -> 지도
            } else {
                dice[1] = map[x][y]; // 지도 -> 바닥
                map[x][y] = 0;
            }

            sb.append(dice[0]).append("\n"); // 윗면 출력
        }

        System.out.print(sb);
    }

    static void rollDice(int dir) {
        int[] temp = dice.clone();
        switch (dir) {
            case 1: // 동
                dice[0] = temp[4];
                dice[1] = temp[5];
                dice[4] = temp[1];
                dice[5] = temp[0];
                break;
            case 2: // 서
                dice[0] = temp[5];
                dice[1] = temp[4];
                dice[4] = temp[0];
                dice[5] = temp[1];
                break;
            case 3: // 북
                dice[0] = temp[3];
                dice[1] = temp[2];
                dice[2] = temp[0];
                dice[3] = temp[1];
                break;
            case 4: // 남
                dice[0] = temp[2];
                dice[1] = temp[3];
                dice[2] = temp[1];
                dice[3] = temp[0];
                break;
        }
    }
}
