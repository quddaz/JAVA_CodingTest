import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int map[][];
    static int n, m;
    static boolean visited[][];
    static int moves[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        visited = new boolean[n][m];
        map = new int[n][m];
        Queue<int[]> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == -1)
                    visited[i][j] = true;
                else if(map[i][j] == 1){
                    q.add(new int[]{i,j,0});
                    visited[i][j] = true;
                }
            }
        }
        int max = 0;
        while(!q.isEmpty()){
            int cnt[] = q.poll();
            int x= cnt[0];
            int y = cnt[1];
            int count = cnt[2];

            max = Math.max(count, max);
            for(int[] move: moves){
                int dx = x + move[0];
                int dy = y + move[1];

                if(dx >= 0 && dy >= 0 && dx < n && dy < m && !visited[dx][dy]){
                    q.add(new int[]{dx,dy,count + 1});
                    map[dx][dy] = count + 1;
                    visited[dx][dy] = true;
                }
            }
        }
        boolean flag = false;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(map[i][j] == 0)
                    flag = true;
            }
        }

        if(flag){
            System.out.println(-1);
        }else{
            System.out.println(max);
        }

    }
}
