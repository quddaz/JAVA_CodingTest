import java.io.*;
import java.util.*;

public class Main {
    static int N, M, MAX = 17;
    static List<Integer>[] tree;
    static int[][] parent;
    static int[] depth;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());

        tree = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) tree[i] = new ArrayList<>();

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            tree[a].add(b);
            tree[b].add(a);
        }

        depth = new int[N + 1];
        parent = new int[N + 1][MAX];
        visited = new boolean[N + 1];

        dfs(1, 0);

        for (int k = 1; k < MAX; k++) {
            for (int i = 1; i <= N; i++) {
                parent[i][k] = parent[parent[i][k - 1]][k - 1];
            }
        }

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            sb.append(lca(a, b)).append("\n");
        }
        System.out.print(sb);
    }

    static void dfs(int current, int d) {
        visited[current] = true;
        depth[current] = d;

        for (int next : tree[current]) {
            if (!visited[next]) {
                parent[next][0] = current;
                dfs(next, d + 1);
            }
        }
    }

    static int lca(int a, int b) {
        if (depth[a] < depth[b]) {
            int temp = a; a = b; b = temp;
        }

        for (int k = MAX - 1; k >= 0; k--) {
            if (depth[a] - depth[b] >= (1 << k)) {
                a = parent[a][k];
            }
        }

        if (a == b) return a;

        for (int k = MAX - 1; k >= 0; k--) {
            if (parent[a][k] != 0 && parent[a][k] != parent[b][k]) {
                a = parent[a][k];
                b = parent[b][k];
            }
        }

        return parent[a][0];
    }
}
