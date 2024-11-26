import java.util.*;
import java.io.*;

class Main {
    static List<int[]> ch = new ArrayList<>();
    static List<int[]> home = new ArrayList<>();
    static boolean[] visited;
    static int result = Integer.MAX_VALUE;
    static int m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int temp = Integer.parseInt(st.nextToken());
                if (temp == 1)
                    home.add(new int[]{i, j});
                else if (temp == 2)
                    ch.add(new int[]{i, j});
            }
        }

        visited = new boolean[ch.size()];
        dfs(0, 0);
        System.out.println(result);
    }

    public static void dfs(int depth, int start) {
        if (depth == m) {
            // 현재 선택된 치킨 집들로 최소 거리 계산
            int totalDistance = 0;
            for (int[] h : home) {
                int minDistance = Integer.MAX_VALUE;
                for (int i = 0; i < ch.size(); i++) {
                    if (visited[i]) {
                        minDistance = Math.min(minDistance, solve(h[0], h[1], ch.get(i)[0], ch.get(i)[1]));
                    }
                }
                totalDistance += minDistance;
            }
            result = Math.min(result, totalDistance);
            return;
        }

        for (int i = start; i < ch.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(depth + 1, i + 1);
                visited[i] = false;
            }
        }
    }

    public static int solve(int x1, int y1, int x2, int y2) {
        return Math.abs(x2 - x1) + Math.abs(y2 - y1); 
    }
}