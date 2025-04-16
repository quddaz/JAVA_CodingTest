import java.io.*;
import java.util.*;

public class Main {
    public static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long target = B / A;
        long minSum = Long.MAX_VALUE;
        long resultX = 0, resultY = 0;

        for (long i = 1; i * i <= target; i++) {
            if (target % i == 0) {
                long m = i;
                long n = target / i;
                if (gcd(m, n) == 1) {
                    long x = A * m;
                    long y = A * n;
                    if (x + y < minSum) {
                        minSum = x + y;
                        resultX = Math.min(x, y);
                        resultY = Math.max(x, y);
                    }
                }
            }
        }

        System.out.println(resultX + " " + resultY);
    }
}
