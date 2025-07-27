import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long n = Long.parseLong(br.readLine());
        System.out.println(fib(n));
    }

    static long fib(long n) {
        if (n == 0) return 0;

        long[][] result = power(new long[][]{{1, 1}, {1, 0}}, n - 1);
        return result[0][0]; // F(n)
    }

    static long[][] power(long[][] mat, long n) {
        if (n == 1) return mat;

        long[][] half = power(mat, n / 2);
        long[][] full = multiply(half, half);

        if (n % 2 == 1)
            return multiply(full, new long[][]{{1, 1}, {1, 0}});
        return full;
    }

    static long[][] multiply(long[][] a, long[][] b) {
        long[][] res = new long[2][2];
        res[0][0] = (a[0][0] * b[0][0] + a[0][1] * b[1][0]) % MOD;
        res[0][1] = (a[0][0] * b[0][1] + a[0][1] * b[1][1]) % MOD;
        res[1][0] = (a[1][0] * b[0][0] + a[1][1] * b[1][0]) % MOD;
        res[1][1] = (a[1][0] * b[0][1] + a[1][1] * b[1][1]) % MOD;
        return res;
    }
}
