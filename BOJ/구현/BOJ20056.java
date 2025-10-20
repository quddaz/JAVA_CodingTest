import java.io.*;
import java.util.*;

public class Main {
    static class Fireball {
        int r, c, m, s, d;
        Fireball(int r, int c, int m, int s, int d) {
            this.r = r; this.c = c; this.m = m; this.s = s; this.d = d;
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Fireball> list = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int m = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            list.add(new Fireball(r, c, m, s, d));
        }

        int[] dr = {-1,-1,0,1,1,1,0,-1};
        int[] dc = {0,1,1,1,0,-1,-1,-1};

        for (int step = 0; step < K; step++) {
            ArrayList<Fireball>[][] grid = new ArrayList[N][N];
            for (int i = 0; i < N; i++) for (int j = 0; j < N; j++) grid[i][j] = new ArrayList<>();

            for (Fireball f : list) {
                int sMod = f.s % N;
                int nr = (f.r + dr[f.d] * sMod) % N;
                int nc = (f.c + dc[f.d] * sMod) % N;
                if (nr < 0) nr += N;
                if (nc < 0) nc += N;
                grid[nr][nc].add(new Fireball(nr, nc, f.m, f.s, f.d));
            }

            list.clear();

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (grid[i][j].isEmpty()) continue;
                    if (grid[i][j].size() == 1) {
                        list.add(grid[i][j].get(0));
                    } else {
                        int sumM = 0, sumS = 0, cnt = grid[i][j].size();
                        boolean allEven = true, allOdd = true;
                        for (Fireball f : grid[i][j]) {
                            sumM += f.m;
                            sumS += f.s;
                            if (f.d % 2 == 0) allOdd = false;
                            else allEven = false;
                        }
                        int newM = sumM / 5;
                        if (newM == 0) continue;
                        int newS = sumS / cnt;
                        int[] dirs = (allEven || allOdd) ? new int[]{0,2,4,6} : new int[]{1,3,5,7};
                        for (int d : dirs) {
                            list.add(new Fireball(i, j, newM, newS, d));
                        }
                    }
                }
            }
        }

        long ans = 0;
        for (Fireball f : list) ans += f.m;
        System.out.println(ans);
    }
}
