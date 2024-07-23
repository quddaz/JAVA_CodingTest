import java.io.*;
import java.util.*;

public class S1_1260 {
    static int N, M, V;
    static boolean visited[];
    static ArrayList<Integer>[] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        V = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        map = new ArrayList[N + 1];
        for (int i = 1; i <= N; i++) {
            map[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a].add(b);
            map[b].add(a);
        }

        for (int i = 1; i <= N; i++) {
            Collections.sort(map[i]);
        }

        dfs(V);
        System.out.println();
        Arrays.fill(visited, false);
        bfs(V);
    }

    public static void dfs(int start) {
        visited[start] = true;
        System.out.print(start + " ");
        for (int i = 0; i < map[start].size(); i++) {
            int next = map[start].get(i);
            if (!visited[next]) {
                dfs(next);
            }
        }
    }

    public static void bfs(int start) {
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        visited[start] = true;

        while (!q.isEmpty()) {
            int num = q.poll();
            System.out.print(num + " ");

            for (Integer next : map[num]) {
                if (!visited[next]) {
                    q.add(next);
                    visited[next] = true;
                }
            }
        }
    }
}