import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] buildTime = new int[N + 1];
        int[] resultTime = new int[N + 1];
        int[] indegree = new int[N + 1];
        List<List<Integer>> graph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            buildTime[i] = Integer.parseInt(st.nextToken());
            while (true) {
                int prev = Integer.parseInt(st.nextToken());
                if (prev == -1) break;
                graph.get(prev).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q = new LinkedList<>();

        for (int i = 1; i <= N; i++) {
            if (indegree[i] == 0) {
                q.offer(i);
                resultTime[i] = buildTime[i];
            }
        }

        while (!q.isEmpty()) {
            int now = q.poll();
            for (int next : graph.get(now)) {
                indegree[next]--;
                resultTime[next] = Math.max(resultTime[next], resultTime[now] + buildTime[next]);
                if (indegree[next] == 0) {
                    q.offer(next);
                }
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(resultTime[i]);
        }
    }
}
