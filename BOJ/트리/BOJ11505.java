import java.io.*;
import java.util.*;

public class Main {
    static final long MOD = 1_000_000_007L;
    static long[] arr, tree;
    static int N, M, K;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        arr = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        tree = new long[4 * N];
        init(1, N, 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M + K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            long c = Long.parseLong(st.nextToken());

            if (a == 1) {
                update(1, N, 1, b, c);
            } else { // query
                sb.append(query(1, N, 1, b, (int)c)).append("\n");
            }
        }

        System.out.print(sb);
    }

    static long init(int start, int end, int node) {
        if (start == end) return tree[node] = arr[start] % MOD;
        int mid = (start + end) / 2;
        return tree[node] = (init(start, mid, node * 2) * init(mid + 1, end, node * 2 + 1)) % MOD;
    }

    static long update(int start, int end, int node, int idx, long val) {
        if (idx < start || idx > end) return tree[node];
        if (start == end) return tree[node] = val % MOD;

        int mid = (start + end) / 2;
        return tree[node] = (update(start, mid, node * 2, idx, val) * update(mid + 1, end, node * 2 + 1, idx, val)) % MOD;
    }

    static long query(int start, int end, int node, int left, int right) {
        if (right < start || end < left) return 1; 
        if (left <= start && end <= right) return tree[node];

        int mid = (start + end) / 2;
        return (query(start, mid, node * 2, left, right) * query(mid + 1, end, node * 2 + 1, left, right)) % MOD;
    }
}