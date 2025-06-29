import java.io.*;
import java.util.*;

public class Main {

    static int F, S, G, U, D;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        F = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        G = Integer.parseInt(st.nextToken());
        U = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        visited = new boolean[F + 1]; 

        int result = bfs();
        if (result == -1) {
            System.out.println("use the stairs");
        } else {
            System.out.println(result);
        }
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{S, 0});
        visited[S] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int floor = cur[0];
            int count = cur[1];

            if (floor == G) return count;

            int up = floor + U;
            if (U > 0 && up <= F && !visited[up]) {
                visited[up] = true;
                queue.add(new int[]{up, count + 1});
            }

            int down = floor - D;
            if (D > 0 && down >= 1 && !visited[down]) {
                visited[down] = true;
                queue.add(new int[]{down, count + 1});
            }
        }

        return -1; 
    }
}
