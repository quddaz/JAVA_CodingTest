import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] L = new int[N]; // 체력 소모
        int[] J = new int[N]; // 기쁨

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            L[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            J[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[101]; 

        for (int i = 0; i < N; i++) {
            for (int h = 100; h >= L[i]; h--) {
                dp[h] = Math.max(dp[h], dp[h - L[i]] + J[i]);
            }
        }

        int answer = 0;
        for (int h = 1; h < 100; h++) {
            answer = Math.max(answer, dp[h]);
        }

        System.out.println(answer);
    }
}
