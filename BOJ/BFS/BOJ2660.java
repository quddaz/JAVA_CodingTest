import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer>[] graph;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == -1 && b == -1) break;
            graph[a].add(b);
            graph[b].add(a);
        }
        
        int[] scores = new int[N + 1];
        int minScore = Integer.MAX_VALUE;
        
        for (int i = 1; i <= N; i++) {
            scores[i] = bfs(i);
            minScore = Math.min(minScore, scores[i]);
        }
        
        List<Integer> candidates = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            if (scores[i] == minScore) candidates.add(i);
        }
        
        System.out.println(minScore + " " + candidates.size());
        for (int c : candidates) {
            System.out.print(c + " ");
        }
    }
    
    static int bfs(int start) {
        int[] dist = new int[N + 1];
        Arrays.fill(dist, -1);
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        dist[start] = 0;
        
        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int nxt : graph[cur]) {
                if (dist[nxt] == -1) {
                    dist[nxt] = dist[cur] + 1;
                    q.add(nxt);
                }
            }
        }
        
        int maxDist = 0;
        for (int i = 1; i <= N; i++) {
            if (dist[i] == -1) return Integer.MAX_VALUE; // 연결 안 된 경우
            maxDist = Math.max(maxDist, dist[i]);
        }
        return maxDist;
    }
}
