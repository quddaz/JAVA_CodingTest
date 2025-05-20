import java.io.*;
import java.util.*;

public class Main {
    static class Point {
        int x, y;
        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static Point[] points;
    static boolean[] visited;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            n = Integer.parseInt(br.readLine());
            points = new Point[n + 2];
            visited = new boolean[n + 2];

            for (int i = 0; i < n + 2; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                points[i] = new Point(x, y);
            }

            System.out.println(bfs() ? "happy" : "sad");
        }
    }

    static boolean bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0); // 상근이네 집
        visited[0] = true;

        while (!queue.isEmpty()) {
            int now = queue.poll();
            Point curr = points[now];

            for (int i = 0; i < points.length; i++) {
                if (!visited[i]) {
                    int distance = Math.abs(curr.x - points[i].x) + Math.abs(curr.y - points[i].y);
                    if (distance <= 1000) { // 맥주 한 박스로 갈 수 있는 거리
                        queue.offer(i);
                        visited[i] = true;
                    }
                }
            }
        }

        return visited[n + 1]; // 페스티벌 도착 가능 여부
    }
}
