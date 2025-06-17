import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int from, to, time;
        Edge(int from, int to, int time) {
            this.from = from;
            this.to = to;
            this.time = time;
        }
    }

    static final long INF = Long.MAX_VALUE;
    static int N, M;
    static List<Edge> edges = new ArrayList<>();
    static long[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        dist = new long[N + 1];
        Arrays.fill(dist, INF);
        dist[1] = 0;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int time = Integer.parseInt(st.nextToken());
            edges.add(new Edge(from, to, time));
        }

        // (N-1)번 반복
        for (int i = 0; i < N - 1; i++) {
            for (Edge edge : edges) {
                if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.time) {
                    dist[edge.to] = dist[edge.from] + edge.time;
                }
            }
        }

        // 음수 사이클 확인
        for (Edge edge : edges) {
            if (dist[edge.from] != INF && dist[edge.to] > dist[edge.from] + edge.time) {
                System.out.println(-1);
                return;
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 2; i <= N; i++) {
            if (dist[i] == INF) sb.append("-1\n");
            else sb.append(dist[i]).append("\n");
        }
        System.out.print(sb);
    }
}
