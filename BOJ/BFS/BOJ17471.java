import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] population;
    static List<Integer>[] adj;
    static boolean[] selected;
    static int minDiff = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        population = new int[N];
        adj = new ArrayList[N];
        selected = new boolean[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            population[i] = Integer.parseInt(st.nextToken());
            adj[i] = new ArrayList<>();
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int count = Integer.parseInt(st.nextToken());
            for (int j = 0; j < count; j++) {
                adj[i].add(Integer.parseInt(st.nextToken()) - 1);
            }
        }

        dfs(0);

        System.out.println(minDiff == Integer.MAX_VALUE ? -1 : minDiff);
    }

    static void dfs(int idx) {
        if (idx == N) {
            List<Integer> groupA = new ArrayList<>();
            List<Integer> groupB = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                if (selected[i]) groupA.add(i);
                else groupB.add(i);
            }

            if (!groupA.isEmpty() && !groupB.isEmpty()) {
                if (isConnected(groupA) && isConnected(groupB)) {
                    int sumA = getPopulation(groupA);
                    int sumB = getPopulation(groupB);
                    minDiff = Math.min(minDiff, Math.abs(sumA - sumB));
                }
            }
            return;
        }
        selected[idx] = true;
        dfs(idx + 1);

        selected[idx] = false;
        dfs(idx + 1);
    }

    static boolean isConnected(List<Integer> group) {
        boolean[] visited = new boolean[N];
        Queue<Integer> q = new LinkedList<>();

        q.add(group.get(0));
        visited[group.get(0)] = true;
        int count = 1;

        while (!q.isEmpty()) {
            int cur = q.poll();
            for (int next : adj[cur]) {
                if (!visited[next] && group.contains(next)) {
                    visited[next] = true;
                    q.add(next);
                    count++;
                }
            }
        }

        return count == group.size();
    }

    static int getPopulation(List<Integer> group) {
        int sum = 0;
        for (int idx : group) sum += population[idx];
        return sum;
    }
}
