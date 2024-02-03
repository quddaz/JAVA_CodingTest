import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int n, m;
    static int[][] graph;
    static boolean[] visited;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int personA = Integer.parseInt(st.nextToken());
        int personB = Integer.parseInt(st.nextToken());

        m = Integer.parseInt(br.readLine());
        graph = new int[n + 1][n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());
            graph[parent][child] = 1;
            graph[child][parent] = 1;
        }

        int result = bfs(personA, personB);

        System.out.println(result);
    }

    static int bfs(int start, int end) {
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(start);
        visited[start] = true;

        int depth = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                int current = queue.poll();

                if (current == end) {
                    return depth;
                }

                for (int j = 1; j <= n; j++) {
                    if (!visited[j] && graph[current][j] == 1) {
                        visited[j] = true;
                        queue.offer(j);
                    }
                }
            }

            depth++;
        }

        return -1; // 두 사람 간의 관계가 전혀 없어 촌수를 계산할 수 없는 경우
    }
}