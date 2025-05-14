import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        
        int indegree[] = new int[n + 1];
        List<List<Integer>> graph = new ArrayList<>();

        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }


        for(int i = 0; i < m; i++){
            st = new StringTokenizer(br.readLine());
            int first = Integer.parseInt(st.nextToken());
            int second = Integer.parseInt(st.nextToken());

            graph.get(first).add(second);
            indegree[second]++;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 1; i <= n; i++){
            if(indegree[i] == 0)
                pq.add(i);
        }


        StringBuilder sb = new StringBuilder();
        while(!pq.isEmpty()){
            int now = pq.poll();
            sb.append(now).append(" ");
            
            for(int next : graph.get(now)){
                indegree[next]--;
                if(indegree[next] == 0)
                    pq.add(next);
            }
        }
        System.out.println(sb);
    }
}
