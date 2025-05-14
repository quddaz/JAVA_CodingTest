import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] time = new int[n + 1];
        int[] indegree = new int[n + 1]; 
        List<List<Integer>> graph = new ArrayList<>();
        int[] dp = new int[n + 1]; 

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            time[i] = t;

            for (int j = 0; j < cnt; j++) {
                int pre = Integer.parseInt(st.nextToken());
                graph.get(pre).add(i); 
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            if (indegree[i] == 0) {
                q.add(i);
                dp[i] = time[i];
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph.get(now)) {
                dp[next] = Math.max(dp[next], dp[now] + time[next]);
                indegree[next]--;
                if (indegree[next] == 0) {
                    q.add(next);
                }
            }
        }

        int max = 0;
        for (int i = 1; i <= n; i++) {
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
