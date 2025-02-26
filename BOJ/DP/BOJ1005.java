import java.io.*;
import java.util.*;

public class Main {
    static int T, N, K, W;
    static int[] time, dp, indegree;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        T = Integer.parseInt(br.readLine()); 

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            K = Integer.parseInt(st.nextToken());

            time = new int[N + 1];
            dp = new int[N + 1];
            indegree = new int[N + 1];
            graph = new ArrayList[N + 1];

            for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();

            st = new StringTokenizer(br.readLine());
            for (int i = 1; i <= N; i++) {
                time[i] = Integer.parseInt(st.nextToken());
            }
            for (int i = 0; i < K; i++) {
                st = new StringTokenizer(br.readLine());
                int X = Integer.parseInt(st.nextToken());
                int Y = Integer.parseInt(st.nextToken());
                graph[X].add(Y);
                indegree[Y]++;
            }

            W = Integer.parseInt(br.readLine());

            sb.append(topologySort()).append("\n");
        }
        System.out.println(sb);
    }

    static int topologySort() {
        Queue<Integer> queue = new LinkedList<>();

 
        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
                dp[i] = time[i]; 
            }
        }

        while (!queue.isEmpty()) {
            int now = queue.poll();

            for (int next : graph[now]) {
                dp[next] = Math.max(dp[next], dp[now] + time[next]);
                if (--indegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return dp[W];
    }
}
