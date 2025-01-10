import java.io.*;
import java.util.*;

public class Main {
    static List<List<Node>> graph = new ArrayList<>();
    static int maxNode;
    static int result = 0;
    static boolean[] visited;

    static class Node {
        int node, weight;

        Node(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int node = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(node).add(new Node(to, weight));
            graph.get(to).add(new Node(node, weight));
        }

        visited = new boolean[n + 1];
        dfs(1, 0);

        visited = new boolean[n + 1];
        result = 0;
        dfs(maxNode, 0);

        System.out.println(result);
    }

    public static void dfs(int node, int distance) {
        if (result < distance) {
            result = distance;
            maxNode = node;
        }

        visited[node] = true;

        for (Node next : graph.get(node)) {
            if (!visited[next.node]) {
                dfs(next.node, distance + next.weight);
            }
        }
    }
}
