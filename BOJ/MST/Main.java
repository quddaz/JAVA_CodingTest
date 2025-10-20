import java.io.*;
import java.util.*;

public class Main {
    static int m, n;
    static int[] parent;

    static class Edge implements Comparable<Edge> {
        int u, v, w;
        Edge(int u, int v, int w) {
            this.u = u; this.v = v; this.w = w;
        }
        @Override
        public int compareTo(Edge o) {
            return this.w - o.w;
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a < b) parent[b] = a;
        else parent[a] = b;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) break;

            List<Edge> edges = new ArrayList<>();
            parent = new int[m];
            for (int i = 0; i < m; i++) parent[i] = i;

            long total = 0;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                edges.add(new Edge(x, y, z));
                total += z;
            }

            Collections.sort(edges);

            long mst = 0;
            for (Edge e : edges) {
                if (find(e.u) != find(e.v)) {
                    union(e.u, e.v);
                    mst += e.w;
                }
            }

            sb.append(total - mst).append("\n");
        }

        System.out.print(sb.toString());
    }
}
