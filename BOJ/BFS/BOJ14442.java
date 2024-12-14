import java.io.*;
import java.util.*;

public class Main {
    static int move[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
    static int N, M, K;
    static int map[][];
    static boolean visited[][][]; // N M K
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M][K+1];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0,K,1});
        visited[0][0][K] = true;

        while(!q.isEmpty()){
            int cnt[] = q.poll();
            int x = cnt[0];
            int y = cnt[1];
            int k = cnt[2];
            int count = cnt[3];
            if(x == N-1 && y == M-1){
                return count;
            }
            for(int i = 0; i < move.length; i++){
                int dx = x + move[i][0];
                int dy = y + move[i][1];
                if(dx >= 0 && dx < N && dy >= 0 && dy < M){
                    if(map[dx][dy] == 1){
                        if(k > 0 && !visited[dx][dy][k-1]){
                            q.add(new int[]{dx,dy,k-1, count+1});
                            visited[dx][dy][k-1] = true;
                        }
                    }else if(!visited[dx][dy][k]){
                        q.add(new int[]{dx,dy,k,count+1});
                        visited[dx][dy][k] = true;
                    }
                }
            }
        }
        return -1;
    }
}
