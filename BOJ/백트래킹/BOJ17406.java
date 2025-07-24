import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K;
    static int[][] original;
    static int[][] operations;
    static int answer = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 입력 처리
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        original = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                original[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        operations = new int[K][3];
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            operations[i][0] = Integer.parseInt(st.nextToken());
            operations[i][1] = Integer.parseInt(st.nextToken());
            operations[i][2] = Integer.parseInt(st.nextToken());
        }

        boolean[] visited = new boolean[K];
        permute(new ArrayList<>(), visited);

        System.out.println(answer);
    }

    static void permute(List<Integer> order, boolean[] visited) {
        if (order.size() == K) {
            int[][] copy = copyArray(original);
            for (int idx : order) {
                int[] op = operations[idx];
                rotate(copy, op[0] - 1, op[1] - 1, op[2]);
            }
            answer = Math.min(answer, getMinRowSum(copy));
            return;
        }

        for (int i = 0; i < K; i++) {
            if (!visited[i]) {
                visited[i] = true;
                order.add(i);
                permute(order, visited);
                order.remove(order.size() - 1);
                visited[i] = false;
            }
        }
    }

    static void rotate(int[][] map, int r, int c, int s) {
        for (int layer = 1; layer <= s; layer++) {
            int top = r - layer;
            int left = c - layer;
            int bottom = r + layer;
            int right = c + layer;

            int prev = map[top][left];

            for (int i = top; i < bottom; i++) {
                map[i][left] = map[i + 1][left];
            }

            for (int i = left; i < right; i++) {
                map[bottom][i] = map[bottom][i + 1];
            }

            for (int i = bottom; i > top; i--) {
                map[i][right] = map[i - 1][right];
            }

            for (int i = right; i > left + 1; i--) {
                map[top][i] = map[top][i - 1];
            }

            map[top][left + 1] = prev;
        }
    }

    static int[][] copyArray(int[][] src) {
        int[][] result = new int[N][M];
        for (int i = 0; i < N; i++) {
            System.arraycopy(src[i], 0, result[i], 0, M);
        }
        return result;
    }
    static int getMinRowSum(int[][] map) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < M; j++) {
                sum += map[i][j];
            }
            min = Math.min(min, sum);
        }
        return min;
    }
}
