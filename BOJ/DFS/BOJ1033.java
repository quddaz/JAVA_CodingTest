import java.util.*;
import java.io.*;

public class Main {
    static class Edge {
        int to, p, q; // a / b = p / q
        Edge(int to, int p, int q) {
            this.to = to;
            this.p = p;
            this.q = q;
        }
    }

    static int N;
    static List<Edge>[] graph;
    static long[] numerator;
    static long[] denominator;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        graph = new ArrayList[N];
        numerator = new long[N];
        denominator = new long[N];
        visited = new boolean[N];

        for (int i = 0; i < N; i++) graph[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());
            int q = Integer.parseInt(st.nextToken());

            graph[a].add(new Edge(b, p, q));
            graph[b].add(new Edge(a, q, p)); // 역방향 (q/p)
        }

        // 0번 재료 기준: 질량 = 1/1
        numerator[0] = 1;
        denominator[0] = 1;
        visited[0] = true;
        dfs(0);

        long lcm = 1;
        for (int i = 0; i < N; i++) {
            lcm = lcm(lcm, denominator[i]);
        }

        long[] result = new long[N];
        for (int i = 0; i < N; i++) {
            result[i] = numerator[i] * (lcm / denominator[i]);
        }

        long gcd = result[0];
        for (int i = 1; i < N; i++) {
            gcd = gcd(gcd, result[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            sb.append(result[i] / gcd).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    static void dfs(int node) {
        for (Edge edge : graph[node]) {
            if (!visited[edge.to]) {
                numerator[edge.to] = numerator[node] * edge.q;
                denominator[edge.to] = denominator[node] * edge.p;
                long g = gcd(numerator[edge.to], denominator[edge.to]);
                numerator[edge.to] /= g;
                denominator[edge.to] /= g;
                visited[edge.to] = true;
                dfs(edge.to);
            }
        }
    }

    static long gcd(long a, long b) {
        while (b != 0) {
            long tmp = a % b;
            a = b;
            b = tmp;
        }
        return a;
    }

    static long lcm(long a, long b) {
        return a * b / gcd(a, b);
    }
}
