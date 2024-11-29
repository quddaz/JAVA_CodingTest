import java.util.*;
import java.io.*;

class Main {
    static int[][] move = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    static int R, C;
    static int[][] fireTime;
    static boolean[][] visitedJ;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        fireTime = new int[R][C];
        visitedJ = new boolean[R][C];

        for (int i = 0; i < R; i++) {
            Arrays.fill(fireTime[i], Integer.MAX_VALUE);
        }

        Queue<int[]> jq = new LinkedList<>();
        Queue<int[]> fq = new LinkedList<>();

        for (int i = 0; i < R; i++) {
            String str = br.readLine();
            for (int j = 0; j < C; j++) {
                char temp = str.charAt(j);
                if (temp == 'F') {
                    fq.add(new int[]{i, j});
                    fireTime[i][j] = 0;
                }
                if (temp == 'J') {
                    jq.add(new int[]{i, j, 0});
                    visitedJ[i][j] = true;
                }
                if (temp == '#') {
                    fireTime[i][j] = -1;
                }
            }
        }

        // 불 BFS
        while (!fq.isEmpty()) {
            int[] farr = fq.poll();

            for (int i = 0; i < move.length; i++) {
                int fx = farr[0] + move[i][0];
                int fy = farr[1] + move[i][1];

                if (fx >= 0 && fx < R && fy >= 0 && fy < C &&
                        fireTime[fx][fy] == Integer.MAX_VALUE) {
                    fireTime[fx][fy] = fireTime[farr[0]][farr[1]] + 1;
                    fq.add(new int[]{fx, fy});
                }
            }
        }

        // Jihoon BFS
        while (!jq.isEmpty()) {
            int[] jarr = jq.poll();

            for (int i = 0; i < move.length; i++) {
                int jx = jarr[0] + move[i][0];
                int jy = jarr[1] + move[i][1];


                if (jx < 0 || jx >= R || jy < 0 || jy >= C) {
                    System.out.println(jarr[2] + 1);
                    return;
                }

                if (jx >= 0 && jx < R && jy >= 0 && jy < C &&
                        !visitedJ[jx][jy] && fireTime[jx][jy] != -1 &&
                        fireTime[jx][jy] > jarr[2] + 1) {
                    visitedJ[jx][jy] = true;
                    jq.add(new int[]{jx, jy, jarr[2] + 1});
                }
            }
        }

        System.out.println("IMPOSSIBLE");
    }
}
