import java.io.*;
import java.util.*;

public class Main {
    static String bfs(int a, int b) {
        boolean[] visited = new boolean[10000];
        Queue<Pair> queue = new LinkedList<>();
        queue.add(new Pair(a, ""));
        visited[a] = true;

        while (!queue.isEmpty()) {
            Pair current = queue.poll();
            int num = current.num;
            String commands = current.commands;

            if (num == b) return commands;

            // D
            int d = (num * 2) % 10000;
            if (!visited[d]) {
                visited[d] = true;
                queue.add(new Pair(d, commands + "D"));
            }

            // S
            int s = (num == 0) ? 9999 : num - 1;
            if (!visited[s]) {
                visited[s] = true;
                queue.add(new Pair(s, commands + "S"));
            }

            // L
            int l = (num % 1000) * 10 + (num / 1000);
            if (!visited[l]) {
                visited[l] = true;
                queue.add(new Pair(l, commands + "L"));
            }

            // R
            int r = (num % 10) * 1000 + (num / 10);
            if (!visited[r]) {
                visited[r] = true;
                queue.add(new Pair(r, commands + "R"));
            }
        }
        return "";
    }

    static class Pair {
        int num;
        String commands;

        Pair(int num, String commands) {
            this.num = num;
            this.commands = commands;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            sb.append(bfs(A, B)).append('\n');
        }
        System.out.print(sb);
    }
}
