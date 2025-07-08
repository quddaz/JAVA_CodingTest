import java.io.*;
import java.util.*;

public class S1_1495 {
    static int N, S, M;
    static int sound[];
    static int result = -1;
    static boolean dp[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        sound = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++){
            sound[i] = Integer.parseInt(st.nextToken());
        }
        dp = new boolean[N+1][M+1];
        dp[0][S] = true;

        for(int i = 0; i < N; i++){
            for(int j = 0; j <=M; j++){
                if(dp[i][j]){
                    if(j + sound[i] <= M){
                        dp[i+1][j + sound[i]] = true;
                    }
                    if(j - sound[i] >= 0){
                        dp[i+1][j - sound[i]] = true;
                    }
                }
            }
        }
        for(int j = M; j >= 0; j--) {
            if(dp[N][j]) {
                result = j;
                break;
            }
        }
        System.out.println(result);
    }
}