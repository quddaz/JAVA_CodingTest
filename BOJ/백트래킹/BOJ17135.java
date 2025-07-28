import java.io.*;
import java.util.*;

public class Main {
    static int map[][];
    static int N, M, D;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M];
        for(int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < M; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);

        System.out.println(result);
    }

    public static void dfs(int depth, int start){
        if(depth == 3){
            result = Math.max(solve(), result);
            return;
        }

        for(int i = start; i < M; i++){
            map[N][i] = 2;
            dfs(depth + 1, i + 1);
            map[N][i] = 0;
        }
    }

    public static int solve() {
        List<int[]> enemies = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 1) enemies.add(new int[]{i, j});
            }
        }

        List<Integer> archers = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            if (map[N][i] == 2) archers.add(i);
        }

        int kill = 0;

        while (!enemies.isEmpty()) {
            Set<Integer> targets = new HashSet<>();

            for (int archer : archers) {
                int minDist = Integer.MAX_VALUE;
                int targetIdx = -1;

                for (int i = 0; i < enemies.size(); i++) {
                    int[] e = enemies.get(i);
                    int dist = Math.abs(e[0] - N) + Math.abs(e[1] - archer);
                    if (dist <= D) {
                        if (dist < minDist || (dist == minDist && e[1] < enemies.get(targetIdx)[1])) {
                            minDist = dist;
                            targetIdx = i;
                        }
                    }
                }

                if (targetIdx != -1) targets.add(targetIdx);
            }

            List<int[]> newEnemies = new ArrayList<>();
            for (int i = 0; i < enemies.size(); i++) {
                if (targets.contains(i)) kill++;
                else newEnemies.add(enemies.get(i));
            }

            List<int[]> movedEnemies = new ArrayList<>();
            for (int[] e : newEnemies) {
                int x = e[0] + 1;
                if (x < N) movedEnemies.add(new int[]{x, e[1]});
            }

            enemies = movedEnemies;
        }

        return kill;
    }

}
