import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int[] visited;
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        visited = new int[100001];
        int result = bfs(N);
        System.out.println(result);
    }

    public static int bfs(int start) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = 0;

        while (!queue.isEmpty()) {
            int current = queue.poll();

            if (current == K) {
                return visited[current];
            }

            // 걷기 경우 (좌측 이동)
            if (current - 1 >= 0 && visited[current - 1] == 0) {
                visited[current - 1] = visited[current] + 1;
                queue.add(current - 1);
            }
            // 걷기 경우 (우측 이동)
            if (current + 1 <= 100000 && visited[current + 1] == 0) {
                visited[current + 1] = visited[current] + 1;
                queue.add(current + 1);
            }
            // 순간이동 경우
            if (2 * current <= 100000 && visited[2 * current] == 0) {
                visited[2 * current] = visited[current] + 1;
                queue.add(2 * current);
            }
        }

        // 여기까지 왔다는 것은 도착하지 못한 경우이므로 -1 반환
        return -1;
    }
}
