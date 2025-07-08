import java.io.*;
import java.util.*;

public class G5_12865 {
    static int dp[];
    static int N, K;
    static int num[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        num = new int[N][2];
        dp = new int[K + 1];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            num[i][0] = w;
            num[i][1] = v;
        }

        for (int i = 0; i < N; i++) {
            int w = num[i][0];
            int v = num[i][1];
            for (int j = K; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }

        System.out.println(dp[K]);
    }
}