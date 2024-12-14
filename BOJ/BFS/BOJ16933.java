import java.io.*;
import java.util.*;

public class Main {
    static int move[][] = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}}; 
    static int N, M, K;
    static int map[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][M];

        for(int i = 0; i < N; i++){
            String str = br.readLine();
            for(int j = 0; j < M; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }

        System.out.println(bfs());
    }

    public static int bfs(){
        Queue<int[]> q = new ArrayDeque<>();
        boolean visited[][][] = new boolean[N][M][K + 1];
        q.add(new int[]{0, 0, K, 0});
        visited[0][0][K] = true;

        while(!q.isEmpty()){
            int cnt[] = q.poll();
            int x = cnt[0];
            int y = cnt[1];
            int k = cnt[2];
            int count = cnt[3];
            int time = count % 2;

            if(x == N-1 && y == M-1){
                return count + 1;
            }

            for(int i = 0; i < move.length; i++){
                int dx = x + move[i][0];
                int dy = y + move[i][1];
                
                if(dx < 0 || dx >= N || dy < 0 || dy >= M) continue;

                if(map[dx][dy] == 0 && !visited[dx][dy][k]) {
                    q.add(new int[] { dx, dy, k, count + 1 });
                    visited[dx][dy][k] = true;
                }

                if(map[dx][dy] == 1 && k > 0 && !visited[dx][dy][k - 1]) {
                    if(time == 0) {
                        q.add(new int[] { dx, dy, k - 1, count + 1 });
                        visited[dx][dy][k - 1] = true;
                    }
                }

                if(map[dx][dy] == 1 && time == 1) {
                    q.add(new int[] { x, y, k, count + 1 });
                    visited[x][y][k] = true;
                }
            }
        }
        return -1;
    }
}