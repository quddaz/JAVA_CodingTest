import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] minCost;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        parent = new int[N + 1];
        minCost = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            parent[i] = i;
            minCost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            union(v, w);
        }

        int[] groupMin = new int[N + 1];
        Arrays.fill(groupMin, Integer.MAX_VALUE);

        for (int i = 1; i <= N; i++) {
            int root = find(i);
            groupMin[root] = Math.min(groupMin[root], minCost[i]);
        }

        // 최소 비용 합산
        long total = 0;
        for (int i = 1; i <= N; i++) {
            if (groupMin[i] != Integer.MAX_VALUE) {
                total += groupMin[i];
            }
        }

        // 결과 출력
        if (total <= k) {
            System.out.println(total);
        } else {
            System.out.println("Oh no");
        }
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB) {
            if (rootA < rootB) parent[rootB] = rootA;
            else parent[rootA] = rootB;
        }
    }
}
