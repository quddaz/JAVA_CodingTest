import java.io.*;
import java.util.*;

public class Main {
    static char[][] map;
    static int result = 0;
    static boolean[][] visited;
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static List<int[]> selected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        visited = new boolean[5][5];
        map = new char[5][5];

        for (int i = 0; i < 5; i++) {
            String str = br.readLine();
            for (int j = 0; j < 5; j++) {
                map[i][j] = str.charAt(j);
            }
        }

        selected = new ArrayList<>();
        combination(0, 0);
        System.out.println(result);
    }

    public static void combination(int start, int depth) {
        if (depth == 7) {
            if (isValid()) {
                result++;
            }
            return;
        }

        for (int i = start; i < 25; i++) {
            int x = i / 5;
            int y = i % 5;
            selected.add(new int[]{x, y});
            combination(i + 1, depth + 1);
            selected.remove(selected.size() - 1);
        }
    }

    // 선택된 칸이 인접한지 확인
    public static boolean isValid() {
        boolean[][] tempVisited = new boolean[5][5];
        int sCount = 0;
        for (int[] pos : selected) {
            int x = pos[0];
            int y = pos[1];
            tempVisited[x][y] = true;
            if (map[x][y] == 'S') sCount++;
        }

        if (sCount < 4) return false;


        Queue<int[]> queue = new LinkedList<>();
        queue.add(selected.get(0));  
        tempVisited[selected.get(0)[0]][selected.get(0)[1]] = false;  // 처음 위치는 방문 처리
        int count = 1;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int dx = curr[0] + move[i][0];
                int dy = curr[1] + move[i][1];

                if (dx < 0 || dx >= 5 || dy < 0 || dy >= 5) continue;
                if (tempVisited[dx][dy]) {
                    tempVisited[dx][dy] = false; 
                    queue.add(new int[]{dx, dy});
                    count++;
                }
            }
        }

        return count == 7;
    }
}
