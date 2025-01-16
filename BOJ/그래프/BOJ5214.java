import java.io.*;
import java.util.*;

public class Main {
    static List<List<Integer>> graph = new ArrayList<>();
    static int n, k, m;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        for(int i = 0; i <= n + m; i++){
            graph.add(new ArrayList<>());
        }

        for(int i = 1; i <= m; i++){
            st = new StringTokenizer(br.readLine());
            int hyper = i + n;
            for(int j = 0; j < k; j++){
                int v = Integer.parseInt(st.nextToken());
                graph.get(v).add(hyper);
                graph.get(hyper).add(v);
            }

        }

        System.out.println(bfs());
    }

    public static int bfs(){
        boolean visited[] = new boolean[n + m +1];
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[] {1, 1});
        visited[1] = true;
        
        while(!q.isEmpty()){
            int cnt[] = q.poll();

            if(cnt[0] == n){
                return cnt[1];
            }
            for(int next : graph.get(cnt[0])){
                if(!visited[next]){
                    if(next > n)
                        q.add(new int[]{next, cnt[1]});
                    else
                        q.add(new int[]{next, cnt[1] + 1});
                    
                    visited[next] = true;
                }
            }
        }
        return -1;
    }
}
