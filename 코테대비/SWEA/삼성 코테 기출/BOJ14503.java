import java.io.*;
import java.util.*;

public class Main {
    static int n, m;
    static int[][] map;
    static int[][] moves = {{-1,0}, {0,1}, {1,0}, {0,-1}}; // 북, 동, 남, 서
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int startX = Integer.parseInt(st.nextToken());
        int startY = Integer.parseInt(st.nextToken());
        int direction = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{startX, startY, direction});
        
        while(!q.isEmpty()){
            int[] cnt = q.poll();
            int x = cnt[0];
            int y = cnt[1];
            int di = cnt[2];

            if(map[x][y] == 0){
                result++;
                map[x][y] = -1;
            }

            boolean flag = false;

            for(int i = 0; i < 4; i++){
                int dx = x + moves[i][0];
                int dy = y + moves[i][1];

                if(dx >= 0 && dx < n && dy >= 0 && dy < m && map[dx][dy] == 0){
                    flag = true;
                    break;
                }
            }

            if(flag){
                for (int i = 0; i < 4; i++) {
                    di = (di + 3) % 4; 
                    int mx = x + moves[di][0];
                    int my = y + moves[di][1];

                    if(mx >= 0 && mx < n && my >= 0 && my < m && map[mx][my] == 0) {
                        q.add(new int[]{mx, my, di});
                        break;
                    }
                }
            } else { 
                int mx = x - moves[di][0];
                int my = y - moves[di][1];

                if(mx < 0 || mx >= n || my < 0 || my >= m || map[mx][my] == 1){
                    System.out.println(result);
                    return;
                } else {
                    q.add(new int[]{mx, my, di});
                }
            }
        }
    }
}
