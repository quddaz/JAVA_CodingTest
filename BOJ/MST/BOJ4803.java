import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int[] rank;
    static int[] nodeCount;
    static int[] edgeCount;
    static boolean[] isTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int caseNum = 1;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());  
            int m = Integer.parseInt(st.nextToken());  

            if (n == 0 && m == 0) break;

            parent = new int[n + 1];
            rank = new int[n + 1];
            nodeCount = new int[n + 1];  
            edgeCount = new int[n + 1];  
            isTree = new boolean[n + 1];

            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                isTree[i] = true;
                nodeCount[i] = 1;
                edgeCount[i] = 0;
            }

            for (int i = 0; i < m; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                union(u, v);
            }

            int treeCount = 0;
            for (int i = 1; i <= n; i++) {
                if (parent[i] == i && isTree[i]) {
                    if (edgeCount[i] == nodeCount[i] - 1) {
                        treeCount++;
                    }
                }
            }


            if (treeCount == 0) {
                System.out.println("Case " + caseNum + ": No trees.");
            } else if (treeCount == 1) {
                System.out.println("Case " + caseNum + ": There is one tree.");
            } else {
                System.out.println("Case " + caseNum + ": A forest of " + treeCount + " trees.");
            }

            caseNum++;
        }
    }

    static int find(int x) {
        if (x != parent[x])
            parent[x] = find(parent[x]); // 경로 압축
        return parent[x];
    }

    static void union(int u, int v) {
        int ru = find(u);
        int rv = find(v);

        if (ru == rv) {
            isTree[ru] = false; 
            edgeCount[ru]++;
        } else {
            if (rank[ru] < rank[rv]) {
                parent[ru] = rv;
                nodeCount[rv] += nodeCount[ru];
                edgeCount[rv] += edgeCount[ru] + 1;
                isTree[rv] &= isTree[ru]; 
            } else {
                parent[rv] = ru;
                nodeCount[ru] += nodeCount[rv];
                edgeCount[ru] += edgeCount[rv] + 1;
                isTree[ru] &= isTree[rv];
                if (rank[ru] == rank[rv])
                    rank[ru]++;
            }
        }
    }
}
