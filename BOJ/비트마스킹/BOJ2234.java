import java.io.*;
import java.util.*;

public class Main {
    static int N, M;
    static int[][] castle;
    static int[][] roomId; 
    static int[] roomSize; 
    static int roomCount = 0;
    static int maxRoomSize = 0;

    static int[] dx = {0, -1, 0, 1};
    static int[] dy = {-1, 0, 1, 0};
    static int[] wallBit = {1, 2, 4, 8};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken()); 
        M = Integer.parseInt(st.nextToken()); 

        castle = new int[M][N];
        roomId = new int[M][N];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                castle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        roomSize = new int[M * N + 1];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (roomId[i][j] == 0) {
                    roomCount++;
                    int size = bfs(i, j, roomCount);
                    roomSize[roomCount] = size;
                    maxRoomSize = Math.max(maxRoomSize, size);
                }
            }
        }

        int maxAfterRemove = 0;
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                for (int d = 0; d < 4; d++) {
                    int nx = i + dx[d];
                    int ny = j + dy[d];

                    if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;

                    if ((castle[i][j] & wallBit[d]) != 0) { 
                        int r1 = roomId[i][j];
                        int r2 = roomId[nx][ny];
                        if (r1 != r2) { 
                            maxAfterRemove = Math.max(maxAfterRemove, roomSize[r1] + roomSize[r2]);
                        }
                    }
                }
            }
        }

        System.out.println(roomCount);
        System.out.println(maxRoomSize);
        System.out.println(maxAfterRemove);
    }

    static int bfs(int x, int y, int id) {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{x, y});
        roomId[x][y] = id;
        int size = 1;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int cx = cur[0], cy = cur[1];

            for (int d = 0; d < 4; d++) {
                int nx = cx + dx[d];
                int ny = cy + dy[d];

                if (nx < 0 || nx >= M || ny < 0 || ny >= N) continue;
                if (roomId[nx][ny] != 0) continue;

                if ((castle[cx][cy] & wallBit[d]) == 0) {
                    roomId[nx][ny] = id;
                    q.add(new int[]{nx, ny});
                    size++;
                }
            }
        }

        return size;
    }
}
