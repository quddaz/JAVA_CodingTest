import java.io.*;
import java.util.*;

public class Main {
    static int[] parent, size;
    static Map<String, Integer> map;
    static int index;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();

        while (T-- > 0) {
            int F = Integer.parseInt(br.readLine());
            map = new HashMap<>();
            parent = new int[F * 2];
            size = new int[F * 2];
            index = 0;

            for (int i = 0; i < F * 2; i++) {
                parent[i] = i;
                size[i] = 1;
            }

            for (int i = 0; i < F; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String a = st.nextToken();
                String b = st.nextToken();

                int aIndex = getIndex(a);
                int bIndex = getIndex(b);

                sb.append(union(aIndex, bIndex)).append('\n');
            }
        }

        System.out.println(sb);
    }

    static int getIndex(String name) {
        if (!map.containsKey(name)) {
            map.put(name, index++);
        }
        return map.get(name);
    }

    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    static int union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);

        if (rootA != rootB) {
            parent[rootB] = rootA;
            size[rootA] += size[rootB];
        }

        return size[find(rootA)];
    }
}
