import java.io.*;
import java.util.*;

public class Main {
    static int n, m, result = Integer.MAX_VALUE;
    static int[][] map;
    static List<int[]> cctv = new ArrayList<>();
    static int[][] moves = {{-1,0},{0,1},{1,0},{0,-1}};
    static int[][][] directions = {
        {}, // 0번 CCTV는 없음
        {{0}, {1}, {2}, {3}}, // 1번 CCTV: 한 방향
        {{0, 2}, {1, 3}}, // 2번 CCTV: 양방향(반대 방향)
        {{0, 1}, {1, 2}, {2, 3}, {3, 0}}, // 3번 CCTV: 직각 방향
        {{0, 1, 2}, {1, 2, 3}, {2, 3, 0}, {3, 0, 1}}, // 4번 CCTV: 세 방향
        {{0, 1, 2, 3}} // 5번 CCTV: 모든 방향
    };
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++){
                map[i][j] = Integer.parseInt(st.nextToken());

                if(map[i][j] > 0 && map[i][j] < 6)
                    cctv.add(new int[]{i,j,map[i][j]});
            }
        }
        dfs(0, map);
        System.out.println(result);
    }

    public static void dfs(int depth, int m[][]){
        if (depth == cctv.size()) {
            result = Math.min(result, getResult(m));
            return;
        }

        int[] cur = cctv.get(depth);
        int x = cur[0], y = cur[1], type = cur[2];
        for (int[] dirSet : directions[type]) {
            int[][] copied = copyMap(m); 
            for (int d : dirSet) {
                setMap(copied, x, y, d); 
            }
            dfs(depth + 1, copied);
        }

    }

    public static int[][] copyMap(int[][] m) {
        int[][] newMap = new int[n][m[0].length];
        for (int i = 0; i < n; i++) {
            newMap[i] = m[i].clone(); 
        }
        return newMap;
    }

    public static void setMap(int ma[][], int x, int y, int flag){
        int dx = moves[flag][0];
        int dy = moves[flag][1];

        while (true) {
            x += dx;
            y += dy;
            if (x < 0 || y < 0 || x >= n || y >= m) break; 
            if (ma[x][y] == 6) break;
            if (ma[x][y] == 0) ma[x][y] = 7; 
        }
    }

    public static int getResult(int ma[][]){
        int count = 0;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(ma[i][j] == 0)
                    count++;
            }
        }
        return count;
    }
}

