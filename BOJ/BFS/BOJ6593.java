import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    static int L, R, C;
    static char[][][] building;
    static int[][][] time; // 방문 여부 체크 및 시간 저장
    // 동, 서, 남, 북, 상, 하 이동을 위한 배열
    static int[] dl = {0, 0, 0, 0, 1, -1};
    static int[] dr = {0, 0, 1, -1, 0, 0};
    static int[] dc = {1, -1, 0, 0, 0, 0};

    static class Point {
        int l, r, c;

        Point(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            L = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());

            if (L == 0 && R == 0 && C == 0) {
                break;
            }

            building = new char[L][R][C];
            time = new int[L][R][C];
            Point start = null;

            for (int i = 0; i < L; i++) {
                for (int j = 0; j < R; j++) {
                    String line = br.readLine();
                    for (int k = 0; k < C; k++) {
                        building[i][j][k] = line.charAt(k);
                        if (building[i][j][k] == 'S') {
                            start = new Point(i, j, k);
                        }
                    }
                }
                br.readLine(); // 각 층 사이의 빈 줄 처리
            }

            int result = bfs(start);

            if (result == -1) {
                sb.append("Trapped!\n");
            } else {
                sb.append("Escaped in ").append(result).append(" minute(s).\n");
            }
        }
        System.out.print(sb);
    }

    static int bfs(Point start) {
        Queue<Point> q = new LinkedList<>();
        q.add(start);
        time[start.l][start.r][start.c] = 0; 

        while (!q.isEmpty()) {
            Point current = q.poll();

            if (building[current.l][current.r][current.c] == 'E') {
                return time[current.l][current.r][current.c];
            }

            for (int i = 0; i < 6; i++) {
                int nextL = current.l + dl[i];
                int nextR = current.r + dr[i];
                int nextC = current.c + dc[i];

                if (nextL < 0 || nextL >= L || nextR < 0 || nextR >= R || nextC < 0 || nextC >= C) {
                    continue;
                }
                if (time[nextL][nextR][nextC] == 0 && building[nextL][nextR][nextC] != '#') {
                     if(building[start.l][start.r][start.c] == building[nextL][nextR][nextC]){
                         continue;
                     }
                    time[nextL][nextR][nextC] = time[current.l][current.r][current.c] + 1;
                    q.add(new Point(nextL, nextR, nextC));
                }
            }
        }
        return -1; 
    }
}