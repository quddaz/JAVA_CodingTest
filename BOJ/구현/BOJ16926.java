import java.io.*;
import java.util.*;

public class Main {
    static int N, M, R;
    static int[][] arr;

    public static void main(String[] args) throws IOException {
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

        rotate();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                sb.append(arr[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    static void rotate() {
        int layers = Math.min(N, M) / 2;

        for (int layer = 0; layer < layers; layer++) {
            List<Integer> list = new ArrayList<>();

            // 위쪽
            for (int j = layer; j < M - layer; j++) list.add(arr[layer][j]);
            // 오른쪽
            for (int i = layer + 1; i < N - layer - 1; i++) list.add(arr[i][M - layer - 1]);
            // 아래쪽
            for (int j = M - layer - 1; j >= layer; j--) list.add(arr[N - layer - 1][j]);
            // 왼쪽
            for (int i = N - layer - 2; i > layer; i--) list.add(arr[i][layer]);

            int len = list.size();
            int rot = R % len;

            List<Integer> rotated = new ArrayList<>();
            for (int k = 0; k < len; k++) {
                rotated.add(list.get((k + rot) % len));
            }

            int idx = 0;
            // 위쪽
            for (int j = layer; j < M - layer; j++) arr[layer][j] = rotated.get(idx++);
            // 오른쪽
            for (int i = layer + 1; i < N - layer - 1; i++) arr[i][M - layer - 1] = rotated.get(idx++);
            // 아래쪽
            for (int j = M - layer - 1; j >= layer; j--) arr[N - layer - 1][j] = rotated.get(idx++);
            // 왼쪽
            for (int i = N - layer - 2; i > layer; i--) arr[i][layer] = rotated.get(idx++);
        }
    }
}
