import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000;
    static long[] fib;
    static long n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Long.parseLong(br.readLine());

        if (n == 0) {
            System.out.println(0);
            return;
        }

        int pisano = setPisano();
        n %= pisano;
        fib = new long[pisano + 1];
        System.out.println(fibonacci(n));
    }

    public static int setPisano() {
        int prev = 0;
        int curr = 1;
        int pisano = 0;
        long limit = 3000000; //피사노 주기의 최대 값을 대략으로 설정

        for (int i = 0; i < limit; i++) {
            int temp = (prev + curr) % MOD;
            prev = curr;
            curr = temp;
            pisano++;
            if (prev == 0 && curr == 1) {
                return pisano;
            }
        }
        return pisano;
    }

    public static long fibonacci(long n) {
        fib[0] = 0;
        fib[1] = 1;
        for (int i = 2; i <= n; i++) {
            fib[i] = (fib[i - 1] + fib[i - 2]) % MOD;
        }
        return fib[(int) n];
    }
}

