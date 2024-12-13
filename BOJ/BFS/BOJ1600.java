import java.io.*;
import java.util.*;

public class Main {
    static int ho[][] = {{-2,-1},{-2,1},{2,-1},{2,1},
                        {1,-2},{-1,-2},{1,2},{-1,2}};
    static int move[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static int K, W, H;
    static int map[][];
    static boolean visited[][][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K  = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        map = new int[W][H];
        visited = new boolean[W][H][K + 1];

        for(int i = 0; i < W; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < H; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = bfs();

        System.out.println(result);
    }
    public static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,0,K}); //{x,y,count,K}
        visited[0][0][K] = true;
        int result = -1;

        while(!q.isEmpty()){
            int cnt[] = q.poll();
            int x = cnt[0];
            int y = cnt[1];
            int count = cnt[2];
            int k = cnt[3];

            if(x == W-1 && y == H-1){
                result = count;
                break;
            }

            if(k > 0){
                for(int i = 0; i < ho.length; i++){
                    int hx = x + ho[i][0];
                    int hy = y + ho[i][1];

                    if(hx >= 0 && hx < W && hy >= 0 && hy < H 
                    && !visited[hx][hy][k-1] && map[hx][hy] != 1){
                        q.add(new int[]{hx,hy,count+1, k-1});
                        visited[hx][hy][k-1] = true;
                    }
                }
            }

            for(int i = 0; i < move.length; i++){
                int dx = x + move[i][0];
                int dy = y + move[i][1];
                if(dx >= 0 && dx < W && dy >= 0 && dy < H 
                && !visited[dx][dy][k] && map[dx][dy] != 1){
                    q.add(new int[]{dx,dy,count+1, k});
                    visited[dx][dy][k] = true;
                }
            }
        }


        return result;
    }
}
