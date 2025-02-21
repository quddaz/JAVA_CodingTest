import java.io.*;
import java.util.*;

public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int graph[][] = new int[n + 1][n + 1];

        for(int i = 1; i <= n; i++){
            Arrays.fill(graph[i], Integer.MAX_VALUE);
            graph[i][i] = 0;
        }


        int m = Integer.parseInt(br.readLine());
        for(int i = 0; i < m; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int dis = Integer.parseInt(st.nextToken());
            graph[a][b] = Math.min(dis, graph[a][b]);
        }

        for (int i = 1; i <= n; i++) {        
            for (int j = 1; j <= n; j++) {  
                for (int k = 1; k <= n; k++) {
                    if (graph[j][i] != Integer.MAX_VALUE && graph[i][k] != Integer.MAX_VALUE) { // 오버플로우 방지
                        graph[j][k] = Math.min(graph[j][k], graph[j][i] + graph[i][k]);
                    }
                }
            }
        }
        
        for(int i = 1; i <= n; i++){
            for(int j = 1; j <= n; j++){
                if(graph[i][j] != Integer.MAX_VALUE)
                    System.out.print(graph[i][j] + " ");
                else
                    System.out.print(0+" ");
            }
            System.out.println();
        }
    }
}
