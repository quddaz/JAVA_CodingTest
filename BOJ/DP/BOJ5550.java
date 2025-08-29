import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static ArrayList<Integer>[] genre;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        genre = new ArrayList[11]; 
        for (int i = 1; i <= 10; i++) genre[i] = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            genre[g].add(c);
        }

        for (int i = 1; i <= 10; i++) {
            Collections.sort(genre[i], Collections.reverseOrder());
        }

        int[] dp = new int[K + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int g = 1; g <= 10; g++) {
            if (genre[g].isEmpty()) continue;

            int size = genre[g].size();
            int[] prefix = new int[size + 1];
            for (int i = 1; i <= size; i++) {
                prefix[i] = prefix[i - 1] + genre[g].get(i - 1);
            }

            int[] ndp = Arrays.copyOf(dp, K + 1);

            for (int t = 1; t <= size; t++) {
                int value = prefix[t] + t * (t - 1);
                for (int k = K; k >= t; k--) {
                    if (dp[k - t] != -1) {
                        ndp[k] = Math.max(ndp[k], dp[k - t] + value);
                    }
                }
            }
            dp = ndp;
        }

        System.out.println(dp[K]);
    }
}
