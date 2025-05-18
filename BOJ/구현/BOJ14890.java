import java.util.*;
import java.io.*;

public class Main {
    static int N, L;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;

        // 가로줄 검사
        for (int i = 0; i < N; i++) {
            if (check(map[i])) answer++;
        }

        // 세로줄 검사
        for (int i = 0; i < N; i++) {
            int[] col = new int[N];
            for (int j = 0; j < N; j++) {
                col[j] = map[j][i];
            }
            if (check(col)) answer++;
        }

        System.out.println(answer);
    }

    static boolean check(int[] line) {
        boolean[] used = new boolean[N];

        for (int i = 0; i < N - 1; i++) {
            int curr = line[i];
            int next = line[i + 1];

            if (curr == next) continue;

            // 높이 차이 1 초과
            if (Math.abs(curr - next) > 1) return false;

            // 내려가는 경사로
            if (curr - next == 1) {
                for (int j = i + 1; j <= i + L; j++) {
                    if (j >= N || line[j] != next || used[j]) return false;
                    used[j] = true;
                }
            }

            // 올라가는 경사로
            else if (curr - next == -1) {
                for (int j = i; j > i - L; j--) {
                    if (j < 0 || line[j] != curr || used[j]) return false;
                    used[j] = true;
                }
            }
        }

        return true;
    }
}
