import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int map[][];
    static int d[][];
    static int moves[][] = {{1,0},{-1,0},{0,1},{0,-1}};
    static int n;
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        d = new int[n][n];
        map = new int[n][n];


        for(int i = 0; i < n; i++){
            Arrays.fill(d[i], Integer.MAX_VALUE);
            String str = br.readLine();
            for(int j = 0; j < n; j++){
                map[i][j] = str.charAt(j) - '0';
            }
        }
        bfs();
        System.out.println(d[n-1][n-1]);
    }
    
    public static void bfs(){
        PriorityQueue<int[]> q = new PriorityQueue<>(Comparator.comparingInt(a -> a[2])); 
        d[0][0] = 0;

        q.add(new int[]{0,0,0}); // x, y, count

        while (!q.isEmpty()) {
            int cnt[] = q.poll();
            int x = cnt[0];
            int y = cnt[1];
            int count = cnt[2];

            if(d[x][y] < count) continue;

            for(int[] move : moves){
                int dx = x + move[0];
                int dy = y + move[1];

                if (dx >= 0 && dx < n && dy >= 0 && dy < n) {
                    int newCount = count + (map[dx][dy] == 0 ? 1 : 0);

                    if (d[dx][dy] > newCount) {
                        d[dx][dy] = newCount;
                        q.add(new int[]{dx, dy, newCount});
                    }
                }
            }
        }

    }
}
