import java.io.*;
import java.util.*;

public class Main {
    static int N, R, Q;
    static ArrayList<Integer>[] tree;
    static int[] subtreeSize;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        tree = new ArrayList[N + 1];
        subtreeSize = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 1; i <= N; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            tree[u].add(v);
            tree[v].add(u);
        }

        dfs(R);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int u = Integer.parseInt(br.readLine());
            sb.append(subtreeSize[u]).append("\n");
        }
        System.out.print(sb);
    }

    static int dfs(int node) {
        visited[node] = true;
        subtreeSize[node] = 1; 

        for (int child : tree[node]) {
            if (!visited[child]) {
                subtreeSize[node] += dfs(child);
            }
        }
        return subtreeSize[node];
    }
}
