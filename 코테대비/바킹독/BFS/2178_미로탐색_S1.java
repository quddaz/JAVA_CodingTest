import java.io.*;
import java.util.*;

public class Main {
    static int map[][];
    static boolean visited[][];
    static int maxValue = 0;
    static int moves[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];

        for(int i = 0; i < n; i++){
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,1});
        visited[0][0] = true;

        while(!q.isEmpty()){
            int[] cnt = q.poll();

            if(cnt[0] == n - 1 && cnt[1] == m - 1){
                System.out.println(cnt[2]);
                return;
            }
            for(int[] move : moves){
                int dx = cnt[0] + move[0];
                int dy = cnt[1] + move[1];

                if(dx >= 0 && dx < n && dy >= 0 && dy < m && !visited[dx][dy] && map[dx][dy] == 1){
                    visited[dx][dy] = true;
                    q.add(new int[]{dx,dy, cnt[2] + 1});
                }
            }
        }
        System.out.println(-1);
    }
}