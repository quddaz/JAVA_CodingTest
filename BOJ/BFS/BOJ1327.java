import java.io.*;
import java.util.*;

public class Main {
    static int N, K;
    static String target;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] nums = new int[N];
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
            start.append(nums[i]);
        }

        // 목표 상태 생성
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= N; i++) {
            sb.append(i);
        }
        target = sb.toString();

        System.out.println(bfs(start.toString()));
    }

    static int bfs(String start) {
        Queue<Node> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(new Node(start, 0));
        visited.add(start);

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.state.equals(target)) {
                return current.depth;
            }

            for (int i = 0; i <= N - K; i++) {
                String next = flip(current.state, i, i + K);
                if (!visited.contains(next)) {
                    visited.add(next);
                    queue.offer(new Node(next, current.depth + 1));
                }
            }
        }

        return -1; // 불가능한 경우
    }

    static String flip(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        sb.append(s.substring(0, start));
        sb.append(new StringBuilder(s.substring(start, end)).reverse());
        sb.append(s.substring(end));
        return sb.toString();
    }

    static class Node {
        String state;
        int depth;

        Node(String state, int depth) {
            this.state = state;
            this.depth = depth;
        }
    }
}
