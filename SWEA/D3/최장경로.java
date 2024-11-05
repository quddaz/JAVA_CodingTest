import java.util.*;
import java.io.*;
 
class Solution {
    static List<List<Integer>> graph;
    static boolean[] visited;
    static int result = 0;
     
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            result = 0;
             
            graph = new ArrayList<>();
            for (int j = 0; j <= N; j++) 
                graph.add(new ArrayList<>());
             
            for (int x = 1; x <= M; x++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                graph.get(a).add(b);
                graph.get(b).add(a);
            }
             
            visited = new boolean[N + 1];  // 방문 여부 배열 초기화
             
            for (int d = 1; d <= N; d++) {
                Arrays.fill(visited, false);  // 각 노드에서 시작 시 방문 배열 초기화
                dfs(d, 1);
            }
             
            System.out.println("#" + i + " " + result);
        }
    }
     
    public static void dfs(int index, int count) {
        visited[index] = true;  // 현재 노드 방문 표시
        result = Math.max(result, count);  // 최장 경로 업데이트
         
        for (Integer num : graph.get(index)) {
            if (!visited[num]) {  // 방문하지 않은 노드만 탐색
                dfs(num, count + 1);
            }
        }
         
        visited[index] = false;  // 다른 경로 탐색을 위해 방문 해제
    }
}