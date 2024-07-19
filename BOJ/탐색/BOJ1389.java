import java.io.*;
import java.util.*;

public class Main {
    static int[] result;
    static int N, M;
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        graph = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph[a].add(b);
            graph[b].add(a);
        }

        result = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            result[i] = bfs(i);
        }


        int minCount = Integer.MAX_VALUE;
        int minIndex = -1;
        for (int i = 1; i <= N; i++) {
            if (result[i] < minCount) {
                minCount = result[i];
                minIndex = i;
            }
        }

        System.out.println(minIndex);
    }
    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        int[] distance = new int[N + 1];
        Arrays.fill(distance, -1);
        distance[start] = 0;
        queue.add(start);

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (int neighbor : graph[node]) {
                if (distance[neighbor] == -1) {
                    distance[neighbor] = distance[node] + 1;
                    queue.add(neighbor);
                }
            }
        }

        int sum = 0;
        for (int i = 1; i <= N; i++) {
            sum += distance[i];
        }
        return sum;
    }
}