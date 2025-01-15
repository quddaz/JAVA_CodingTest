import java.io.*;
import java.util.*;

public class Main {
    static int[] colors; 
    static List<Integer>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int K = Integer.parseInt(br.readLine()); 

        while (K-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int V = Integer.parseInt(st.nextToken()); 
            int E = Integer.parseInt(st.nextToken()); 

            graph = new ArrayList[V + 1];
            colors = new int[V + 1];

            for (int i = 1; i <= V; i++) {
                graph[i] = new ArrayList<>();
            }

            for (int i = 0; i < E; i++) {
                st = new StringTokenizer(br.readLine());
                int u = Integer.parseInt(st.nextToken());
                int v = Integer.parseInt(st.nextToken());
                graph[u].add(v);
                graph[v].add(u);
            }

            boolean isBipartite = true;

            for (int i = 1; i <= V; i++) {
                if (colors[i] == 0) {
                    if (!bfs(i)) { 
                        isBipartite = false;
                        break;
                    }
                }
            }

            sb.append(isBipartite ? "YES" : "NO").append("\n");
        }

        System.out.print(sb.toString());
    }

    static boolean bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        colors[start] = 1;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            for (int next : graph[current]) {
                if (colors[next] == 0) { 
                    colors[next] = 3 - colors[current]; 
                    queue.add(next);
                } else if (colors[next] == colors[current]) { 
                    return false;
                }
            }
        }

        return true;
    }
}
