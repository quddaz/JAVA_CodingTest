import java.util.*;
import java.io.*;

public class Main {
    static int N;
    static int[][] board;
    static Deque<int[]> snake = new LinkedList<>();
    static Map<Integer, Character> directionChanges = new HashMap<>();
    
    // 우, 하, 좌, 상
    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        N = Integer.parseInt(br.readLine());
        board = new int[N][N];

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;
            board[x][y] = 1; // 사과 위치
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            char dir = st.nextToken().charAt(0);
            directionChanges.put(time, dir);
        }

        System.out.println(simulate());
    }

    static int simulate() {
        int time = 0;
        int direction = 0;
        snake.offerFirst(new int[]{0, 0});
        boolean[][] visited = new boolean[N][N];
        visited[0][0] = true;

        while (true) {
            time++;
            int[] head = snake.peekFirst();
            int nx = head[0] + dx[direction];
            int ny = head[1] + dy[direction];

            // 벽이나 자기 몸과 부딪히면 종료
            if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                return time;
            }

            // 이동
            snake.offerFirst(new int[]{nx, ny});
            visited[nx][ny] = true;

            if (board[nx][ny] == 1) {
                board[nx][ny] = 0; // 사과 먹음
            } else {
                int[] tail = snake.pollLast();
                visited[tail[0]][tail[1]] = false;
            }

            // 방향 전환
            if (directionChanges.containsKey(time)) {
                char c = directionChanges.get(time);
                if (c == 'L') {
                    direction = (direction + 3) % 4;
                } else {
                    direction = (direction + 1) % 4;
                }
            }
        }
    }
}
