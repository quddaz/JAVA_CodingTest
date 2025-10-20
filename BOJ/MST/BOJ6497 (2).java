import java.io.*;
import java.util.*;

public class Main {
    static class Edge implements Comparable<Edge> {
        int u, v;
        int w;
        Edge(int u, int v, int w) { this.u = u; this.v = v; this.w = w; }
        public int compareTo(Edge o) { return Integer.compare(this.w, o.w); }
    }

    static class UnionFind {
        int[] p;
        int[] r;
        UnionFind(int n) {
            p = new int[n];
            r = new int[n];
            for (int i = 0; i < n; i++) p[i] = i;
        }
        int find(int x) { return p[x] == x ? x : (p[x] = find(p[x])); }
        boolean union(int a, int b) {
            a = find(a); b = find(b);
            if (a == b) return false;
            if (r[a] < r[b]) p[a] = b;
            else if (r[b] < r[a]) p[b] = a;
            else { p[b] = a; r[a]++; }
            return true;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        String line;
        while ((line = br.readLine()) != null) {
            if (line.trim().isEmpty()) continue;
            st = new StringTokenizer(line);
            int m = Integer.parseInt(st.nextToken());
            int n = Integer.parseInt(st.nextToken());
            if (m == 0 && n == 0) break;

            ArrayList<Edge> edges = new ArrayList<>(n);
            long total = 0L;
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int z = Integer.parseInt(st.nextToken());
                edges.add(new Edge(x, y, z));
                total += z;
            }

            Collections.sort(edges);
            UnionFind uf = new UnionFind(m);
            long mst = 0L;
            int used = 0;
            for (Edge e : edges) {
                if (uf.union(e.u, e.v)) {
                    mst += e.w;
                    used++;
                    if (used == m - 1) break;
                }
            }

            System.out.println(total - mst);
        }
    }
}
