import java.io.*;
import java.util.*;

public class Main {
    static final int INF = 100_000_000; 
    static int[][] dist, next;
    static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine()); 
        m = Integer.parseInt(br.readLine()); 

        dist = new int[n + 1][n + 1];
        next = new int[n + 1][n + 1];

        // 거리 배열 초기화
        for (int i = 1; i <= n; i++) {
            Arrays.fill(dist[i], INF);
            dist[i][i] = 0; 
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if (c < dist[a][b]) { 
                dist[a][b] = c;
                next[a][b] = b;
            }
        }

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    if (dist[i][k] != INF && dist[k][j] != INF && dist[i][k] + dist[k][j] < dist[i][j]) {
                        dist[i][j] = dist[i][k] + dist[k][j];
                        next[i][j] = next[i][k];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == INF) sb.append("0 ");
                else sb.append(dist[i][j]).append(" ");
            }
            sb.append("\n");
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (dist[i][j] == 0 || dist[i][j] == INF) {
                    sb.append("0\n");
                } else {
                    List<Integer> path = new ArrayList<>();
                    int s = i;
                    while (s != j) {
                        path.add(s);
                        s = next[s][j];
                    }
                    path.add(j);
                    sb.append(path.size()).append(" ");
                    for (int city : path) {
                        sb.append(city).append(" ");
                    }
                    sb.append("\n");
                }
            }
        }

        System.out.print(sb);
    }
}