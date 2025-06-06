import java.util.*;
import java.io.*;

public class Main {
    static int[] parent;

    static int find(int x) {
        if (parent[x] != x)
            parent[x] = find(parent[x]);
        return parent[x];
    }

    static void union(int a, int b) {
        int rootA = find(a);
        int rootB = find(b);
        if (rootA != rootB)
            parent[rootB] = rootA;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine()); 
        int m = Integer.parseInt(br.readLine()); 
        
        parent = new int[n + 1];
        for (int i = 1; i <= n; i++)
            parent[i] = i;

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j <= n; j++) {
                int connected = Integer.parseInt(st.nextToken());
                if (connected == 1)
                    union(i, j);
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int firstCity = Integer.parseInt(st.nextToken());
        boolean isPossible = true;
        while (st.hasMoreTokens()) {
            int nextCity = Integer.parseInt(st.nextToken());
            if (find(firstCity) != find(nextCity)) {
                isPossible = false;
                break;
            }
        }

        System.out.println(isPossible ? "YES" : "NO");
    }
}
