import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[][] innings;
    static boolean[] used = new boolean[9];
    static int[] order = new int[9];
    static int maxScore = 0;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        innings = new int[N][9];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 9; j++) {
                innings[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        order[3] = 0;
        used[0] = true;
        dfs(0);
        System.out.println(maxScore);
    }

    static void dfs(int pos) {
        if (pos == 9) {
            simulate();
            return;
        }
        if (pos == 3) {
            dfs(pos + 1);
            return;
        }
        for (int p = 1; p < 9; p++) {
            if (!used[p]) {
                used[p] = true;
                order[pos] = p;
                dfs(pos + 1);
                used[p] = false;
            }
        }
    }

    static void simulate() {
        int score = 0;
        int curBatterPos = 0;

        for (int inning = 0; inning < N; inning++) {
            int outs = 0;
            boolean[] base = new boolean[4];

            while (outs < 3) {
                int player = order[curBatterPos];
                int action = innings[inning][player];
                if (action == 0) {
                    outs++;
                } else if (action == 1) {
                    if (base[3]) { score++; base[3] = false; }
                    if (base[2]) { base[3] = true; base[2] = false; }
                    if (base[1]) { base[2] = true; base[1] = false; }
                    base[1] = true;
                } else if (action == 2) {
                    if (base[3]) { score++; base[3] = false; }
                    if (base[2]) { score++; base[2] = false; }
                    if (base[1]) { base[3] = true; base[1] = false; }
                    base[2] = true;
                } else if (action == 3) {
                    if (base[3]) { score++; base[3] = false; }
                    if (base[2]) { score++; base[2] = false; }
                    if (base[1]) { score++; base[1] = false; }
                    base[3] = true;
                } else if (action == 4) {
                    if (base[3]) { score++; base[3] = false; }
                    if (base[2]) { score++; base[2] = false; }
                    if (base[1]) { score++; base[1] = false; }
                    score++;
                }
                curBatterPos = (curBatterPos + 1) % 9;
            }
        }
        if (score > maxScore) maxScore = score;
    }
}
