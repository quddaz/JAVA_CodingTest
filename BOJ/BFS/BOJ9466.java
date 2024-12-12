import java.io.*;
import java.util.*;

public class Main {
    static boolean visited[];
    static int map[];
    static boolean finished[];
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int i = 1; i <= T; i++){
            int n = Integer.parseInt(br.readLine());
            StringTokenizer st = new StringTokenizer(br.readLine());
            map = new int[n+1];
            visited = new boolean[n+1];
            finished = new boolean[n+1];
            result = 0;
            for(int x = 1; x <= n; x++){
                map[x] = Integer.parseInt(st.nextToken());
            }


            for(int x = 1; x <= n; x++){
                if(!visited[x])
                    dfs(x);
            }
            System.out.println(n-result);
        }
    }
    public static void dfs(int node){
        visited[node] = true;

        int next = map[node];

        if(!visited[next]){
            dfs(next);
        }else if (!finished[next]){
            for (int temp = next; temp != node; temp = map[temp]) {
                result++;
            }
            result++;
        }
        finished[node] = true;
    }
}
