import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<Integer>[] trustGraph;
    static boolean[] visited;
    static int[] count;
    static int n, m;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        
        trustGraph = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        count = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            trustGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            trustGraph[b].add(a); 
        }

        result = 0;

        // 모든 노드에 대해 DFS 수행
        for (int i = 1; i <= n; i++) {
            Arrays.fill(visited, false); 
            int numHacked = dfs(i); // i번 노드에서 시작하는 DFS 수행
            result = Math.max(result, numHacked);
            count[i] = numHacked;
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            if (count[i] == result) {
                System.out.println(i+" "+ result);
            }
        }
    }

    // DFS 함수
    private static int dfs(int v) {
        visited[v] = true;
        int count = 1; 
        
        for (int next : trustGraph[v]) {
            if (!visited[next]) { // 방문하지 않은 경우에만 DFS 호출
                count += dfs(next);
            }
        }
        
        return count;
    }
}

