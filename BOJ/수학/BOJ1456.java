import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());

        long sqrtB = (long) Math.sqrt(B);
        boolean[] isPrime = new boolean[(int) sqrtB + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for (int i = 2; i * i <= sqrtB; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= sqrtB; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        int count = 0;
        for (int i = 2; i <= sqrtB; i++) {
            if (isPrime[i]) {
                long value = (long) i * i;
                while (value <= B) {
                    if (value >= A) {
                        count++;
                    }
                    if (value > B / i) break; // 오버플로우 방지
                    value *= i;
                }
            }
        }

        System.out.println(count);
    }
}
