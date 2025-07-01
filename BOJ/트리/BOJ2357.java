import java.io.*;
import java.util.*;

public class Main {
    static int[] arr, minTree, maxTree;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int size = 1;
        while (size < n) size <<= 1;
        size <<= 1; 
        minTree = new int[size];
        maxTree = new int[size];

        build(1, 1, n);

        StringBuilder sb = new StringBuilder();
        while (m-- > 0) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken());
            int right = Integer.parseInt(st.nextToken());
            sb.append(queryMin(1, 1, n, left, right)).append(" ")
              .append(queryMax(1, 1, n, left, right)).append("\n");
        }

        System.out.print(sb);
    }

    static void build(int node, int start, int end) {
        if (start == end) {
            minTree[node] = arr[start];
            maxTree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            build(node * 2, start, mid);
            build(node * 2 + 1, mid + 1, end);
            minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
            maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
        }
    }

    static int queryMin(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return Integer.MAX_VALUE;
        if (l <= start && end <= r) return minTree[node];
        int mid = (start + end) / 2;
        return Math.min(queryMin(node * 2, start, mid, l, r),
                        queryMin(node * 2 + 1, mid + 1, end, l, r));
    }

    static int queryMax(int node, int start, int end, int l, int r) {
        if (r < start || end < l) return Integer.MIN_VALUE;
        if (l <= start && end <= r) return maxTree[node];
        int mid = (start + end) / 2;
        return Math.max(queryMax(node * 2, start, mid, l, r),
                        queryMax(node * 2 + 1, mid + 1, end, l, r));
    }
}
