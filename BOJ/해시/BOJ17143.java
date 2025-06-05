import java.io.*;
import java.util.*;

public class Main {
    static class Shark {
        int r, c, s, d, z;
        Shark(int r, int c, int s, int d, int z) {
            this.r = r; this.c = c;
            this.s = s; this.d = d;
            this.z = z;
        }
    }

    static int R, C, M;
    static int[][] dir = {{0,0}, {-1,0}, {1,0}, {0,1}, {0,-1}};
    static Map<String, Shark> sharks = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int z = Integer.parseInt(st.nextToken());

            // 속도 최적화
            if (d <= 2) s %= (2 * (R - 1));
            else s %= (2 * (C - 1));
            sharks.put(r + "," + c, new Shark(r, c, s, d, z));
        }

        int result = 0;

        for (int col = 0; col < C; col++) {
            // 1. 낚시왕이 해당 열에서 가장 가까운 상어를 잡음
            int targetRow = R;
            String targetKey = null;
            for (int row = 0; row < R; row++) {
                String key = row + "," + col;
                if (sharks.containsKey(key)) {
                    targetRow = row;
                    targetKey = key;
                    break;
                }
            }
            if (targetKey != null) {
                result += sharks.get(targetKey).z;
                sharks.remove(targetKey);
            }

            // 2. 상어 이동
            Map<String, Shark> newSharks = new HashMap<>();
            for (Shark shark : sharks.values()) {
                int r = shark.r;
                int c = shark.c;
                int s = shark.s;
                int d = shark.d;
                int z = shark.z;

                for (int i = 0; i < s; i++) {
                    int nr = r + dir[d][0];
                    int nc = c + dir[d][1];
                    if (nr < 0 || nr >= R || nc < 0 || nc >= C) {
                        if (d == 1) d = 2;
                        else if (d == 2) d = 1;
                        else if (d == 3) d = 4;
                        else if (d == 4) d = 3;
                        nr = r + dir[d][0];
                        nc = c + dir[d][1];
                    }
                    r = nr;
                    c = nc;
                }

                String key = r + "," + c;
                if (!newSharks.containsKey(key) || newSharks.get(key).z < z) {
                    newSharks.put(key, new Shark(r, c, s, d, z));
                }
            }
            sharks = newSharks;
        }

        System.out.println(result);
    }
}
