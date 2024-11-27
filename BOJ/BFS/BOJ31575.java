import java.util.*;
import java.io.*;

class Main {
    static boolean visited[][];
    static int N, M;
    static int map[][];
    static int move[][] = {{1, 0}, {0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        //기본 변수 초기화
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        visited = new boolean[N][M];

        //배열 초기화
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        if(bfs())
            System.out.println("Yes");
        else
            System.out.println("No");

    }
    
    public static boolean bfs(){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0});

        visited[0][0] = true;

        while(!q.isEmpty()){
            int point[] = q.poll();
            int x = point[0];
            int y = point[1];
            if(x == N - 1 && y == M - 1){
                return true;
            }
            for(int[] d : move){
                int move_x = x + d[0];
                int move_y = y + d[1];
                if(move_x < N && move_y < M && !visited[move_x][move_y] && map[move_x][move_y] == 1){
                        q.add(new int[] {move_x, move_y});
                        visited[move_x][move_y] = true;
                    }
            }
        }

        return false;
    }
}
