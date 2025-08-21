import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] S;
    static boolean[] selected;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        S = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                S[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        selected = new boolean[N];
        dfs(0);

        System.out.println(minDiff);
    }

    static void dfs(int idx) {
        if (idx == N) {
            int startSum = 0;
            int linkSum = 0;
            int startCount = 0, linkCount = 0;

            for (int i = 0; i < N; i++) {
                for (int j = i + 1; j < N; j++) {
                    if (selected[i] && selected[j]) {
                        startSum += S[i][j] + S[j][i];
                        startCount++;
                    } else if (!selected[i] && !selected[j]) {
                        linkSum += S[i][j] + S[j][i];
                        linkCount++;
                    }
                }
            }

            if (startCount == 0 || linkCount == 0) return;

            minDiff = Math.min(minDiff, Math.abs(startSum - linkSum));
            return;
        }

        selected[idx] = true;
        dfs(idx + 1);

        selected[idx] = false;
        dfs(idx + 1);
    }
}
