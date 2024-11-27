import java.util.*;
import java.io.*;

class Main {
    static int n, m, h;
    static int map[][][];
    static Queue<int[]> q = new LinkedList<>();
    static int moves[][] = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}
                        ,{0, 0, -1}, {0, 0, 1}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        h = Integer.parseInt(st.nextToken());

        map = new int[h][n][m];

        //맵 초기화
        for(int x = 0; x < h; x++){
            for(int y = 0; y < n; y++){
                st = new StringTokenizer(br.readLine());
                for(int z = 0; z < m; z++){
                    int temp = Integer.parseInt(st.nextToken());
                    map[x][y][z] = temp;
                    if(temp == 1)
                        q.add(new int[]{x,y,z});
                }
            }
        }
        int count = 0;
        boolean flag = false;
        while(!check() && !q.isEmpty()){
            bfs();
            count++;
        }

        if(check())
            System.out.println(count);
        else
            System.out.println(-1);

    }

    public static void bfs(){
        int size = q.size();
        for(int i = 0; i < size; i++){
            int point[] = q.poll();
            int dh = point[0];
            int dx = point[1];
            int dy = point[2];

            for(int[] move : moves){
                int move_h = dh + move[0];
                int move_x = dx + move[1];
                int move_y = dy + move[2];

                if(move_h >= 0 && move_h < h && move_x >= 0 && move_x < n 
                && move_y >= 0 && move_y < m && map[move_h][move_x][move_y] == 0){
                    map[move_h][move_x][move_y] = 1;
                    q.add(new int[]{move_h, move_x, move_y});
                }
            }
        }
    }
    public static boolean check(){
        for(int x = 0; x < h; x++){
            for(int y = 0; y < n; y++){
                for(int z = 0; z < m; z++){
                    if(map[x][y][z] == 0)
                        return false;
                }
            }
        }
        return true;
    }
}
