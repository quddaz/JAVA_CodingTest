import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int MAX = 100000;

        boolean[] isPrime = new boolean[MAX + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i <= MAX; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int[] factorCount = new int[MAX + 1];
        for (int i = 2; i <= MAX; i++) {
            if (factorCount[i] == 0) { 
                for (int j = i; j <= MAX; j += i) {
                    int temp = j;
                    while (temp % i == 0) {
                        factorCount[j]++;
                        temp /= i;
                    }
                }
            }
        }

        int ans = 0;
        for (int i = A; i <= B; i++) {
            if (isPrime[factorCount[i]]) {
                ans++;
            }
        }

        System.out.println(ans);
    }
}
