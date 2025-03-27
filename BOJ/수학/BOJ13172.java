import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    static long modInverse(long b, int mod) {
        return power(b, mod - 2, mod);
    }

    static long power(long base, long exp, int mod) {
        long result = 1;
        while (exp > 0) {
            if ((exp & 1) == 1) {
                result = (result * base) % mod;
            }
            base = (base * base) % mod;
            exp >>= 1;
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        long numerator = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long S = Long.parseLong(st.nextToken());
            numerator = (numerator + S * modInverse(N, MOD)) % MOD;
        }

        System.out.println(numerator);
    }
}
