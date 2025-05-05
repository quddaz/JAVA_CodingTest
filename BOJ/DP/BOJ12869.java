import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

import javax.lang.model.element.QualifiedNameable;

public class Main {
    static StringTokenizer st;
    static int n;
    static int scv[];
    static int dp[][][] = new int[61][61][61];
    static int atteck[][] = {
        {9, 3, 1},
        {9, 1, 3},
        {3, 9, 1},
        {3, 1, 9},
        {1, 9, 3},
        {1, 3, 9}
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        scv = new int[3];
        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < 61; i++) {
            for (int j = 0; j < 61; j++) {
                Arrays.fill(dp[i][j], Integer.MAX_VALUE);
            }
        }

        for(int i = 0 ; i < n; i++){
            scv[i] = Integer.parseInt(st.nextToken());
        }

        bfs();

        System.out.println(dp[0][0][0]);
    }

    public static void bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{scv[0], scv[1], scv[2], 0});
        dp[scv[0]][scv[1]][scv[2]] = 0;

        while(!q.isEmpty()){
            int cnt[] = q.poll();
            int scv1 = cnt[0];
            int scv2 = cnt[1];
            int scv3 = cnt[2];
            int count = cnt[3];

            for(int i = 0; i < atteck.length; i++){
                int m1 = Math.max(0, scv1 - atteck[i][0]);
                int m2 = Math.max(0, scv2 - atteck[i][1]);
                int m3 = Math.max(0, scv3 - atteck[i][2]);

                if(dp[m1][m2][m3] > count + 1){
                    dp[m1][m2][m3] = count + 1;
                    q.add(new int[]{m1,m2,m3,count + 1});
                }
            }
        }
    }
}
