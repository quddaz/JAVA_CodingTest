import java.util.*;

public class Main {
    static int N, M, R;
    static ArrayList<Integer>[] graph;
    static boolean[] visited;
    static int[] order;
    static int count = 1;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        N = sc.nextInt();  // 정점의 수
        M = sc.nextInt();  // 간선의 수
        R = sc.nextInt();  // 시작 정점
        
        graph = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        order = new int[N + 1];
        
        // 그래프 초기화
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }
        
        // 간선 정보 입력
        for (int i = 0; i < M; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            graph[u].add(v);
            graph[v].add(u);
        }
        
        // 인접 리스트 정렬 (오름차순으로 방문하기 위해)
        for (int i = 1; i <= N; i++) {
            Collections.sort(graph[i]);
        }
        
        // DFS 시작
        dfs(R);
        
        // 결과 출력
        for (int i = 1; i <= N; i++) {
            System.out.println(order[i]);
        }
        
        sc.close();
    }
    
    static void dfs(int node) {
        visited[node] = true;
        order[node] = count++;
        
        for (int next : graph[node]) {
            if (!visited[next]) {
                dfs(next);
            }
        }
    }
}
