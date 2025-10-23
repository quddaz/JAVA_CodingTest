import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        while (st.hasMoreTokens()) {
            int cmd = Integer.parseInt(st.nextToken());
            switch (cmd) {
                case 1 : arr = op1();
                    break;
                case 2 : arr = op2();
                    break;
                case 3 : arr = op3();
                    break;
                case 4 : arr = op4();
                    break;
                case 5 : arr = op5();
                    break;
                case 6 : arr = op6();
                    break;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int[] row : arr) {
            for (int v : row) sb.append(v).append(" ");
            sb.append("\n");
        }
        System.out.print(sb);
    }

    // 1. 상하 반전
    static int[][] op1() {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            tmp[i] = arr[N - 1 - i].clone();
        }
        return tmp;
    }

    // 2. 좌우 반전
    static int[][] op2() {
        int[][] tmp = new int[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[i][j] = arr[i][M - 1 - j];
            }
        }
        return tmp;
    }

    // 3. 오른쪽 90도 회전
    static int[][] op3() {
        int[][] tmp = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[j][N - 1 - i] = arr[i][j];
            }
        }
        int t = N;
        N = M;
        M = t;
        return tmp;
    }

    // 4. 왼쪽 90도 회전
    static int[][] op4() {
        int[][] tmp = new int[M][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                tmp[M - 1 - j][i] = arr[i][j];
            }
        }
        int t = N;
        N = M;
        M = t;
        return tmp;
    }

    // 5. 4분할 시계 방향 이동
    static int[][] op5() {
        int[][] tmp = new int[N][M];
        int n2 = N / 2, m2 = M / 2;

        // 4 -> 1
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                tmp[i][j + m2] = arr[i][j];
            }
        }
        // 1 -> 2
        for (int i = 0; i < n2; i++) {
            for (int j = m2; j < M; j++) {
                tmp[i + n2][j] = arr[i][j];
            }
        }
        // 2 -> 3
        for (int i = n2; i < N; i++) {
            for (int j = m2; j < M; j++) {
                tmp[i][j - m2] = arr[i][j];
            }
        }
        // 3 -> 4
        for (int i = n2; i < N; i++) {
            for (int j = 0; j < m2; j++) {
                tmp[i - n2][j] = arr[i][j];
            }
        }
        return tmp;
    }

    // 6. 4분할 반시계 방향 이동
    static int[][] op6() {
        int[][] tmp = new int[N][M];
        int n2 = N / 2, m2 = M / 2;

        // 1 -> 4
        for (int i = 0; i < n2; i++) {
            for (int j = 0; j < m2; j++) {
                tmp[i + n2][j] = arr[i][j];
            }
        }
        // 4 -> 3
        for (int i = n2; i < N; i++) {
            for (int j = 0; j < m2; j++) {
                tmp[i][j + m2] = arr[i][j];
            }
        }
        // 3 -> 2
        for (int i = n2; i < N; i++) {
            for (int j = m2; j < M; j++) {
                tmp[i - n2][j] = arr[i][j];
            }
        }
        // 2 -> 1
        for (int i = 0; i < n2; i++) {
            for (int j = m2; j < M; j++) {
                tmp[i][j - m2] = arr[i][j];
            }
        }
        return tmp;
    }
}
