import java.io.*;
import java.util.*;

public class Main {
    static List<int[]> perms = new ArrayList<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine().trim());

        int[] base = {0, 1, 2, 3, 4};
        genPerm(base, 0);

        Map<String, Integer> freq = new HashMap<>();

        for (int t = 0; t < N; t++) {
            int E = Integer.parseInt(br.readLine().trim());

            int[][] adj = new int[5][5];
            for (int i = 0; i < E; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1; 
                int b = Integer.parseInt(st.nextToken()) - 1;
                adj[a][b] = adj[b][a] = 1;
            }

            String key = canonical(adj);
            freq.put(key, freq.getOrDefault(key, 0) + 1);
        }

        int beautiful = 0;
        for (int c : freq.values()) {
            if (c == 1) beautiful++;
        }
        System.out.println(beautiful);
    }

    static String canonical(int[][] adj) {
        String best = null;

        for (int[] p : perms) {
            StringBuilder sb = new StringBuilder(25);
            for (int i = 0; i < 5; i++) {
                int pi = p[i];
                for (int j = 0; j < 5; j++) {
                    int pj = p[j];
                    sb.append(adj[pi][pj]); 
                }
            }
            String cur = sb.toString();
            if (best == null || cur.compareTo(best) < 0) best = cur;
        }

        return best;
    }
    static void genPerm(int[] arr, int idx) {
        if (idx == arr.length) {
            perms.add(arr.clone());
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            swap(arr, idx, i);
            genPerm(arr, idx + 1);
            swap(arr, idx, i);
        }
    }

    static void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
}
