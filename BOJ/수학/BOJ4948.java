import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static final int MAX = 123456 * 2;
    static boolean[] isNotPrime = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i * i <= MAX; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j <= MAX; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line;

        while ((line = br.readLine()) != null) {
            int n = Integer.parseInt(line);
            if (n == 0) break;

            int count = 0;
            for (int i = n + 1; i <= 2 * n; i++) {
                if (!isNotPrime[i]) count++;
            }

            System.out.println(count);
        }
    }
}