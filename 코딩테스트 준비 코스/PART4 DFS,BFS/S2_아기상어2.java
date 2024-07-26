import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] map;
    static int[][] distance;
    static int[] dx = {-1, -1, 0, 0, 1, 1, 1, -1};
    static int[] dy = {-1, 1, 1, -1, 1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        distance = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        Queue<int[]> q = new LinkedList<>();
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(map[i][j] == 1){
                    distance[i][j] = 0;
                    q.add(new int[]{i,j,0});
                }
            }
        }

        while(!q.isEmpty()){
            int current[] = q.poll();
            int x = current[0];
            int y = current[1];
            int dist = current[2];

            for(int i = 0; i < dx.length; i++){
                int move_x = x + dx[i];
                int move_y = y + dy[i];
                if(isValid(move_x, move_y) && distance[move_x][move_y] > dist + 1){
                    distance[move_x][move_y] = dist + 1;
                    q.add(new int[]{move_x,move_y, dist+1});
                }
            }
        }
        int max = 0;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < M; j++){
                if(max < distance[i][j])
                    max = distance[i][j];
            }
        }
        System.out.println(max);
    }

    public static boolean isValid(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }
}
