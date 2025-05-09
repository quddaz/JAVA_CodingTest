import java.io.*;
import java.util.*;

public class Main {
    static int[] board = new int[101];
    static boolean[] visited = new boolean[101];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }

        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{1, 0});
        visited[1] = true;

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int position = now[0];
            int moves = now[1];

            if (position == 100) {
                System.out.println(moves);
                return;
            }

            for (int dice = 1; dice <= 6; dice++) {
                int next = position + dice;
                if (next > 100) continue;
                if (board[next] != 0) next = board[next];
                if (!visited[next]) {
                    visited[next] = true;
                    queue.add(new int[]{next, moves + 1});
                }
            }
        }
    }
}
