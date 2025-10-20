import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    static int find(int x) {
        if (x == parent[x]) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int a, int b) {
        a = find(a);
        b = find(b);
        parent[a] = b;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int G = Integer.parseInt(br.readLine());
        int P = Integer.parseInt(br.readLine());

        parent = new int[G + 1];
        for (int i = 0; i <= G; i++) parent[i] = i;

        int answer = 0;
        for (int i = 0; i < P; i++) {
            int g = Integer.parseInt(br.readLine());
            int available = find(g);
            if (available == 0) break;
            answer++;
            union(available, available - 1);
        }

        System.out.println(answer);
    }
}
