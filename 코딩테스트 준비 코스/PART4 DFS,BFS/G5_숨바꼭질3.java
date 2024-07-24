iimport java.io.*;
import java.util.*;

public class Main {
import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static int[] dist = new int[100001]; // 최단 거리를 저장할 배열

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N >= K) {
            System.out.println(N - K); // N이 K보다 크거나 같은 경우에는 단순히 걸어가는 것이 최단 시간
        } else {
            bfs();
            System.out.println(dist[K]); // K에 도달하는 최단 시간 출력
        }
    }

    public static void bfs() {
        Deque<Integer> deque = new LinkedList<>();
        Arrays.fill(dist, Integer.MAX_VALUE);
        deque.add(N);
        dist[N] = 0;

        while (!deque.isEmpty()) {
            int current = deque.poll();

            if (current * 2 <= 100000 && dist[current * 2] > dist[current]) {
                dist[current * 2] = dist[current];
                deque.addFirst(current * 2); // 가중치가 0인 경우 덱의 앞에 추가
            }

            if (current + 1 <= 100000 && dist[current + 1] > dist[current] + 1) {
                dist[current + 1] = dist[current] + 1;
                deque.addLast(current + 1); // 가중치가 1인 경우 덱의 뒤에 추가
            }

            if (current - 1 >= 0 && dist[current - 1] > dist[current] + 1) {
                dist[current - 1] = dist[current] + 1;
                deque.addLast(current - 1); // 가중치가 1인 경우 덱의 뒤에 추가
            }
        }
    }
}