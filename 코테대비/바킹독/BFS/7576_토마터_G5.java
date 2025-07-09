import java.io.*;
import java.util.*;

public class Main {
    static int map[][];
    static int moves[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static int n, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        Queue<int[]> q = new LinkedList<>();


        int count = 0;
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 1) {
                    q.add(new int[]{i, j, 0});
                }
            }
        }

        while(!q.isEmpty()){
            int[] cnt = q.poll();
            int x = cnt[0], y = cnt[1], day = cnt[2];
            count = Math.max(count, day);

            for(int[] move : moves){
                int dx = x + move[0];
                int dy = y + move[1];

                if(dx >= 0 && dx < n && dy >= 0 && dy < m && map[dx][dy] == 0){
                    map[dx][dy] = 1;
                    q.add(new int[]{dx,dy, cnt[2] + 1});
                }
            }
        }
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                if(map[i][j] == 0) {
                    System.out.println(-1);
                    return;
                }
            }       
        }
        System.out.println(count);
    }
}