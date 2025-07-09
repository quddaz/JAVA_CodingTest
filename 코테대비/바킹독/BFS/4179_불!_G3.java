import java.io.*;
import java.util.*;

public class Main {
    static char map[][];
    static int moves[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static int n, m;
    static Queue<int[]> fire = new LinkedList<>();
    static int timer[][];
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        timer = new int[n][m];

        visited = new boolean[n][m];

        int jx = 0; int jy = 0;
        for(int i = 0; i < n; i++){
            Arrays.fill(timer[i], Integer.MAX_VALUE);
            String str = br.readLine();
            for(int j = 0; j < m; j++){
                map[i][j] = str.charAt(j);
                if(map[i][j] == 'F'){
                    fire.add(new int[]{i,j,0});
                    visited[i][j] = true;
                }

                if(map[i][j] == 'J'){
                    jx = i;
                    jy = j;
                }
            }
        }

        setFireTimer();

        Queue<int[]> q = new LinkedList<>();
        visited = new boolean[n][m];
        q.add(new int[]{jx,jy,0});
        visited[jx][jy] = true;
        while(!q.isEmpty()){
            int cnt[] = q.poll();
            int x = cnt[0];
            int y = cnt[1];
            int count = cnt[2];
            if(x == 0 || x == n -1 || y == 0 || y == m-1){
                System.out.println(count + 1);
                return;
            }
            for(int[] move : moves){
                int dx = x + move[0];
                int dy = y + move[1];
                if(dx >= 0 && dx < n && dy >= 0 && dy < m && map[dx][dy] == '.' && !visited[dx][dy] && timer[dx][dy] > count + 1){
                    visited[dx][dy] = true;
                    q.add(new int[]{dx,dy,count + 1});
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    public static void setFireTimer(){
        while(!fire.isEmpty()){
            int cnt[] = fire.poll();
            int x = cnt[0];
            int y = cnt[1];
            int count = cnt[2];

            for(int[] move : moves){
                int dx = x + move[0];
                int dy = y + move[1];
                if(dx >= 0 && dx < n && dy >= 0 && dy < m && map[dx][dy] != '#' && !visited[dx][dy]){
                    visited[dx][dy] = true;
                    timer[dx][dy] = count + 1;
                    fire.add(new int[]{dx,dy,count + 1});
                }
            }
        }
    }
}