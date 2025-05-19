import java.util.*;

public class Main {
    static List<Integer>[] graph;
    static boolean[] visited;
    static int N, M;
    static boolean found = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();

        graph = new ArrayList[N];
        for (int i = 0; i < N; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            graph[a].add(b);
            graph[b].add(a);
        }

        visited = new boolean[N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(visited, false); // 매번 새롭게 방문 체크
            dfs(i, 1);
            if (found) {
                System.out.println(1);
                return;
            }
        }

        System.out.println(0);
    }

    static void dfs(int current, int depth) {
        if (depth == 5) {
            found = true;
            return;
        }

        visited[current] = true;
        for (int next : graph[current]) {
            if (!visited[next]) {
                dfs(next, depth + 1);
                if (found) return;
            }
        }
        visited[current] = false;
    }
}
