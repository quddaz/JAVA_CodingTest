import java.io.*;
import java.util.*;

public class Main {

    static List<List<Integer>> graph = new ArrayList<>();
    static boolean visited[];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(st.nextToken());

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        
        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for(int i = 1; i <= n; i++){
            Collections.sort(graph.get(i));
        }

        visited = new boolean[n+1];
        dfs(start);

        sb.append("\n");

        visited = new boolean[n+1];
        bfs(start);

        System.out.println(sb);
    }
    public static void dfs(int target){
        visited[target] = true;
        sb.append(target).append(" ");

        for(int next : graph.get(target)){
            if(!visited[next]){
                dfs(next);
            }
        }
    }

    public static void bfs(int target){
        Queue<Integer> q = new LinkedList<>();
        q.add(target);
        visited[target] = true;

        while(!q.isEmpty()){
            int cnt = q.poll();

            sb.append(cnt).append(" ");

            for(int next : graph.get(cnt)){
                if(!visited[next]){
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}
