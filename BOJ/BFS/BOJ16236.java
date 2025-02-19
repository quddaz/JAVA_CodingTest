import java.io.*;
import java.util.*;

public class Main {
    static class Shark {
        int x, y, size, eatCount;
        
        public Shark(int x, int y) {
            this.x = x;
            this.y = y;
            this.size = 2;
            this.eatCount = 0;
        }
        
        public void grow() {
            if (++eatCount == size) {
                size++;
                eatCount = 0;
            }
        }
    }

    static int N, time;
    static int[][] map;
    static Shark shark;
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    shark = new Shark(i, j);
                    map[i][j] = 0; // 아기 상어 위치 초기화
                }
            }
        }

        // BFS로 물고기를 찾아가면서 시간을 누적
        while (true) {
            int result = bfs();
            if (result == -1) break; // 먹을 물고기가 없으면 종료
            time += result;
        }

        System.out.println(time);
    }

    static int bfs() {
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[N][N];
        queue.add(new int[]{shark.x, shark.y, 0});
        visited[shark.x][shark.y] = true;

        List<int[]> fishList = new ArrayList<>();
        int minDist = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int x = cur[0], y = cur[1], dist = cur[2];

            if (dist > minDist) break;

            for (int d = 0; d < 4; d++) {
                int nx = x + dx[d];
                int ny = y + dy[d];

                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) continue;
                if (map[nx][ny] > shark.size) continue;

                visited[nx][ny] = true;
                queue.add(new int[]{nx, ny, dist + 1});

                if (map[nx][ny] > 0 && map[nx][ny] < shark.size) { // 먹을 수 있는 물고기
                    fishList.add(new int[]{nx, ny, dist + 1});
                    minDist = dist;
                }
            }
        }

        if (fishList.isEmpty()) return -1;

        // 가장 위쪽, 왼쪽에 있는 물고기 선택
        fishList.sort((a, b) -> a[0] == b[0] ? Integer.compare(a[1], b[1]) : Integer.compare(a[0], b[0]));

        int[] target = fishList.get(0);
        int fx = target[0], fy = target[1];

        // 상어 이동 및 성장
        shark.x = fx;
        shark.y = fy;
        shark.grow();
        map[fx][fy] = 0;

        return target[2]; // 이동 시간 반환
    }
}
