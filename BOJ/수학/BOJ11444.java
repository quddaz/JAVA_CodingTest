import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());

        System.out.println(fibonacci(n));
    }

    static long fibonacci(long n) {
        if (n == 0) return 0;

        long[][] result = power(new long[][]{{1, 1}, {1, 0}}, n - 1);
        return result[0][0];
    }

    static long[][] power(long[][] matrix, long exp) {
        long[][] result = {{1, 0}, {0, 1}}; // 단위 행렬

        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = multiply(result, matrix);
            }
            matrix = multiply(matrix, matrix);
            exp >>= 1;
        }

        return result;
    }

    static long[][] multiply(long[][] a, long[][] b) {
        long[][] res = new long[2][2];

        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                res[i][j] = (a[i][0] * b[0][j] % MOD + a[i][1] * b[1][j] % MOD) % MOD;
            }
        }

        return res;
    }
}
