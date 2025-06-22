import java.util.*;

public class Main {
    static char[][] field = new char[12][6];
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 12; i++) {
            field[i] = sc.next().toCharArray();
        }

        int chainCount = 0;

        while (true) {
            visited = new boolean[12][6];
            boolean exploded = false;

            for (int i = 0; i < 12; i++) {
                for (int j = 0; j < 6; j++) {
                    if (field[i][j] != '.' && !visited[i][j]) {
                        if (bfs(i, j)) {
                            exploded = true;
                        }
                    }
                }
            }

            if (!exploded) break; 

            applyGravity();
            chainCount++;
        }

        System.out.println(chainCount);
    }

    static boolean bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        List<int[]> group = new ArrayList<>();
        char color = field[x][y];

        queue.add(new int[]{x, y});
        group.add(new int[]{x, y});
        visited[x][y] = true;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            for (int d = 0; d < 4; d++) {
                int nx = cur[0] + dx[d];
                int ny = cur[1] + dy[d];

                if (nx >= 0 && nx < 12 && ny >= 0 && ny < 6 && !visited[nx][ny] && field[nx][ny] == color) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    group.add(new int[]{nx, ny});
                }
            }
        }

        if (group.size() >= 4) {
            for (int[] pos : group) {
                field[pos[0]][pos[1]] = '.';
            }
            return true;
        }
        return false;
    }

    static void applyGravity() {
        for (int j = 0; j < 6; j++) {
            int emptyRow = 11;
            for (int i = 11; i >= 0; i--) {
                if (field[i][j] != '.') {
                    char temp = field[i][j];
                    field[i][j] = '.';
                    field[emptyRow][j] = temp;
                    emptyRow--;
                }
            }
        }
    }
}
