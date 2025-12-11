import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static final int MAX = 1000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 에라토스테네스의 체로 소수 미리 계산
        boolean[] prime = new boolean[MAX + 1];
        for (int i = 2; i <= MAX; i++) prime[i] = true;

        for (int i = 2; i * i <= MAX; i++) {
            if (!prime[i]) continue;
            for (int j = i * i; j <= MAX; j += i) {
                prime[j] = false;
            }
        }

        StringBuilder sb = new StringBuilder();
        while (true) {
            String line = br.readLine();
            if (line == null) break;
            int n = Integer.parseInt(line);

            if (n == 0) break;

            boolean found = false;

            // a는 홀수 소수만 탐색
            for (int a = 3; a <= n; a += 2) {
                if (prime[a] && prime[n - a]) {
                    sb.append(n).append(" = ").append(a).append(" + ").append(n - a).append("\n");
                    found = true;
                    break;
                }
            }

            if (!found) {
                sb.append("Goldbach's conjecture is wrong.\n");
            }
        }

        System.out.println(sb.toString());
    }
}
