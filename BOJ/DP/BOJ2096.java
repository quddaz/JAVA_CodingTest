import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] maxDp, minDp, num;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        
        maxDp = new int[2][3];
        minDp = new int[2][3];
        num = new int[N][3];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                num[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int j = 0; j < 3; j++) {
            maxDp[0][j] = num[0][j];
            minDp[0][j] = num[0][j];
        }

        for (int i = 1; i < N; i++) {
            maxDp[1][0] = num[i][0] + Math.max(maxDp[0][0], maxDp[0][1]);
            maxDp[1][1] = num[i][1] + Math.max(Math.max(maxDp[0][0], maxDp[0][1]), maxDp[0][2]);
            maxDp[1][2] = num[i][2] + Math.max(maxDp[0][1], maxDp[0][2]);

            minDp[1][0] = num[i][0] + Math.min(minDp[0][0], minDp[0][1]);
            minDp[1][1] = num[i][1] + Math.min(Math.min(minDp[0][0], minDp[0][1]), minDp[0][2]);
            minDp[1][2] = num[i][2] + Math.min(minDp[0][1], minDp[0][2]);

            for (int j = 0; j < 3; j++) {
                maxDp[0][j] = maxDp[1][j];
                minDp[0][j] = minDp[1][j];
            }
        }


        int maxScore = Math.max(Math.max(maxDp[0][0], maxDp[0][1]), maxDp[0][2]);
        int minScore = Math.min(Math.min(minDp[0][0], minDp[0][1]), minDp[0][2]);

        System.out.println(maxScore + " " + minScore);
    }
}
