import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class G5_12851 {

    static int[] map;  // 위치에 도달하는 최소 시간
    static int[] count;  // 최소 시간으로 도달하는 방법의 수
    static boolean[] visited;  // 방문 여부
    static int N, K;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        
        // 배열 초기화
        map = new int[100001];
        count = new int[100001];
        visited = new boolean[100001];
        
        // 시작 위치 초기화
        map[N] = 0;
        count[N] = 1;
        
        // BFS 탐색 시작
        bfs(N);
        
        // 결과 출력
        System.out.println(map[K]);
        System.out.println(count[K]);
    }

    public static void bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int n = queue.poll();
            int currentTime = map[n];
            int currentWays = count[n];
            
            for (int next : new int[] {n + 1, n - 1, n * 2}) {
                if (next >= 0 && next <= 100000) {
                    if (!visited[next]) {
                        visited[next] = true;
                        queue.add(next);
                        map[next] = currentTime + 1;
                        count[next] = currentWays;
                    } else if (map[next] == currentTime + 1) {
                        count[next] += currentWays;
                    }
                }
            }
        }
    }
}
