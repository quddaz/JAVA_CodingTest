import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 1_000_000_000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<Integer> li = new ArrayList<>();

        while (true) {
            int cnt = Integer.parseInt(st.nextToken());
            if (cnt == 0) break;
            li.add(cnt);
        }

        int[][][] dp = new int[5][5][li.size() + 1];

        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                for (int z = 0; z <= li.size(); z++) {
                    dp[i][j][z] = INF;
                }
            }
        }
        dp[0][0][0] = 0;

        for (int i = 0; i < li.size(); i++) {
            int cnt = li.get(i);
            for (int x = 0; x < 5; x++) {
                for (int y = 0; y < 5; y++) {
                    if (dp[x][y][i] != INF) {
                        if (cnt != y) {
                            dp[cnt][y][i + 1] = Math.min(dp[cnt][y][i + 1], dp[x][y][i] + getCost(x, cnt));
                        }
                        if (cnt != x) {
                            dp[x][cnt][i + 1] = Math.min(dp[x][cnt][i + 1], dp[x][y][i] + getCost(y, cnt));
                        }
                    }
                }
            }
        }

        int min = INF;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                min = Math.min(min, dp[i][j][li.size()]);
            }
        }
        System.out.println(min);
    }

    static int getCost(int from, int to) {
        if (from == to) return 1;
        if (from == 0) return 2;
        if ((from == 1 && to == 3) || (from == 3 && to == 1)
                || (from == 2 && to == 4) || (from == 4 && to == 2)) return 4;
        return 3;
    }
}
