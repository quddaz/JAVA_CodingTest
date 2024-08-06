import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] ar;
    static boolean[] visited;
    static int[] parents;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        ar = new ArrayList[N + 1];
        parents = new int[N + 1];
        visited = new boolean[N + 1];
        for(int i = 1; i <= N; i++){
            ar[i] = new ArrayList<>();
        }

        for(int i = 1; i < N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            ar[a].add(b);
            ar[b].add(a);
        }
        visited[1] = true;
        dfs(1);
        for(int i = 2; i <= N; i++){
            System.out.println(parents[i]);
        }
    }
    private static void dfs(int node){
        for(int neighbor : ar[node]){
            if(!visited[neighbor]){
                visited[neighbor] = true;
                parents[neighbor] = node;
                dfs(neighbor);
            }
        }
    }
}
