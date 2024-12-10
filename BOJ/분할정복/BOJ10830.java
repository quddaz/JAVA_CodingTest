import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static final int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        int[][] matrix = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                matrix[i][j] = Integer.parseInt(st.nextToken()) % MOD;
            }
        }

        int[][] result = power(matrix, B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.print(sb);
    }

    public static int[][] power(int[][] matrix, long exp) {
        if (exp == 1) {
            return matrix;
        }

        int[][] half = power(matrix, exp / 2);
        half = multiply(half, half);

        if (exp % 2 == 1) {
            half = multiply(half, matrix);
        }
        return half;
    }

    public static int[][] multiply(int[][] a, int[][] b) {
        int[][] result = new int[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    result[i][j] += (a[i][k] * b[k][j]) % MOD;
                    result[i][j] %= MOD;
                }
            }
        }
        return result;
    }
}
