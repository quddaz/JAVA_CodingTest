import java.io.*;
import java.util.*;

public class Main {

    static class Edge {
        int u, v;
        double w;

        Edge(int u, int v, double w) {
            this.u = u;
            this.v = v;
            this.w = w;
        }
    }

    static int[] parent;

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a == b) return false;
        parent[b] = a;
        return true;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] x = new int[N + 1];
        int[] y = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            x[i] = Integer.parseInt(st.nextToken());
            y[i] = Integer.parseInt(st.nextToken());
        }

        parent = new int[N + 1];
        for (int i = 1; i <= N; i++) parent[i] = i;

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            union(a, b);
        }

        List<Edge> edges = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                double dist = Math.sqrt(
                        Math.pow(x[i] - x[j], 2) + Math.pow(y[i] - y[j], 2)
                );
                edges.add(new Edge(i, j, dist));
            }
        }

        edges.sort(Comparator.comparingDouble(e -> e.w));

        double answer = 0.0;

        for (Edge e : edges) {
            if (union(e.u, e.v)) {
                answer += e.w;
            }
        }

        System.out.printf("%.2f\n", answer);
    }
}
