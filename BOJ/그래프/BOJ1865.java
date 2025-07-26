import java.io.*;
import java.util.*;

public class Main {
    static class Edge {
        int start, end, time;
        Edge(int s, int e, int t) {
            start = s;
            end = e;
            time = t;
        }
    }

    static int TC, N, M, W;
    static List<Edge> edges;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        TC = Integer.parseInt(br.readLine());

        while (TC-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            edges = new ArrayList<>();

            // 도로 (양방향)
            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, t));
                edges.add(new Edge(e, s, t)); // 양방향
            }

            // 웜홀 (단방향, 시간 감소 → 음수 간선)
            for (int i = 0; i < W; i++) {
                st = new StringTokenizer(br.readLine());
                int s = Integer.parseInt(st.nextToken());
                int e = Integer.parseInt(st.nextToken());
                int t = Integer.parseInt(st.nextToken());
                edges.add(new Edge(s, e, -t));
            }

            System.out.println(bellmanFord(N, edges) ? "YES" : "NO");
        }
    }

    static boolean bellmanFord(int n, List<Edge> edges) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, 0);

        for (int i = 1; i <= n; i++) {
            for (Edge edge : edges) {
                if (dist[edge.end] > dist[edge.start] + edge.time) {
                    dist[edge.end] = dist[edge.start] + edge.time;
                    if (i == n) return true;
                }
            }
        }

        return false;
    }
}
