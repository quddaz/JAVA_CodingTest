import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static final int MAX = 100000;
    static int[] map;    // 각 위치까지 도달하는 최소 시간
    static int[] parent; // 경로 추적을 위한 부모 위치
    static boolean[] visited; // 방문 여부
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[MAX + 1];
        parent = new int[MAX + 1];
        visited = new boolean[MAX + 1];
        
        for (int i = 0; i <= MAX; i++) {
            map[i] = -1; 
        }
        map[N] = 0;
        parent[N] = -1; 
        
        bfs(N);
        
        System.out.println(map[K]);
        
        printPath(K);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int n = queue.poll();
            
            if (n == K) {
                return;
            }
            
            int[] nextPositions = {n - 1, n + 1, n * 2};
            
            for (int next : nextPositions) {
                if (next >= 0 && next <= MAX && !visited[next]) {
                    visited[next] = true;
                    map[next] = map[n] + 1;
                    parent[next] = n;
                    queue.add(next);
                }
            }
        }
    }

    public static void printPath(int end) {
        LinkedList<Integer> path = new LinkedList<>();
        for (int at = end; at != -1; at = parent[at]) {
            path.addFirst(at);
        }
        System.out.println(String.join(" ", path.toString().replaceAll("[\\[\\],]", "")));
    }
}
