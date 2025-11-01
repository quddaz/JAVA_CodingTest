import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        double pA = Integer.parseInt(br.readLine().trim()) / 100.0;
        double pB = Integer.parseInt(br.readLine().trim()) / 100.0;
        int n = 18;
        boolean[] isPrime = new boolean[n + 1];
        int[] primes = {2,3,5,7,11,13,17};
        for (int pr : primes) isPrime[pr] = true;
        double pa = probPrimeCount(n, pA, isPrime);
        double pb = probPrimeCount(n, pB, isPrime);
        double result = pa + pb - pa * pb;
        System.out.println(result);
    }

    static double probPrimeCount(int n, double p, boolean[] isPrime) {
        double[] prob = new double[n + 1];
        if (p == 0.0) {
            prob[0] = 1.0;
        } else if (p == 1.0) {
            prob[n] = 1.0;
        } else {
            double q = 1.0 - p;
            prob[0] = Math.pow(q, n);
            for (int k = 0; k < n; k++) {
                prob[k + 1] = prob[k] * (n - k) * p / ((k + 1) * q);
            }
        }
        double sum = 0.0;
        for (int i = 0; i <= n; i++) {
            if (isPrime[i]) sum += prob[i];
        }
        return sum;
    }
}
