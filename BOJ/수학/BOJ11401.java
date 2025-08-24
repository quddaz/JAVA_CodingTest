import java.io.*;
import java.util.*;

public class Main {
    static final int MOD = 1_000_000_007;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (K < 0 || K > N) {
            System.out.println(0);
            return;
        }
        if (K > N - K) K = N - K;

        int[] fact = new int[N + 1];
        int[] invFact = new int[N + 1];

        fact[0] = 1;
        for (int i = 1; i <= N; i++) {
            fact[i] = (int)((fact[i - 1] * 1L * i) % MOD);
        }

        invFact[N] = modPow(fact[N], MOD - 2);
        for (int i = N; i >= 1; i--) {
            invFact[i - 1] = (int)((invFact[i] * 1L * i) % MOD);
        }

        long ans = fact[N];
        ans = (ans * invFact[K]) % MOD;
        ans = (ans * invFact[N - K]) % MOD;

        System.out.println(ans);
    }

    static int modPow(int a, int e) {
        long base = a;
        long res = 1;
        while (e > 0) {
            if ((e & 1) == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            e >>= 1;
        }
        return (int)res;
    }
}