import java.io.*;
import java.util.*;

public class Main {
    static int[][] map;
    static int n;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        map = new int[n][n];
        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        boolean visited[] = new boolean[n];

        dfs(0,visited,0);

        System.out.println(result);
    }
    public static void dfs(int depth, boolean visited[], int start){
        if(depth == n/2){
            int startTeam = 0;
            int linkTeam  = 0;
            for(int i = 0; i < n; i++){
                for(int j = i + 1; j < n; j++){
                    if(visited[i] && visited[j]){
                        startTeam  += map[i][j] + map[j][i];
                    }
                    if(!visited[i] && !visited[j]){
                        linkTeam  += map[i][j] + map[j][i];
                    }
                }
            }
            result = Math.min(result, Math.abs(startTeam  - linkTeam ));
            return;
        }


        for(int i = start; i < n; i++){
            if(!visited[i]){
                visited[i] = true;
                dfs(depth + 1, visited, i+1);
                visited[i] = false;
            }
        }
    }
}
