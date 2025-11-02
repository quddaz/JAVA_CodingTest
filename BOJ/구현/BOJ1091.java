import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] P = new int[N];
        int[] S = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) P[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) S[i] = Integer.parseInt(st.nextToken());

        int[] pos = new int[N];
        for (int i = 0; i < N; i++) pos[i] = i;

        boolean ok = true;
        for (int i = 0; i < N; i++) {
            if (pos[i] % 3 != P[i]) {
                ok = false;
                break;
            }
        }
        if (ok) {
            System.out.println(0);
            return;
        }

        int[] start = pos.clone();
        int steps = 0;

        while (true) {
            steps++;
            int[] nextPos = new int[N];
            for (int i = 0; i < N; i++) {
                nextPos[i] = S[pos[i]];
            }
            pos = nextPos;

            boolean matched = true;
            for (int i = 0; i < N; i++) {
                if (pos[i] % 3 != P[i]) {
                    matched = false;
                    break;
                }
            }
            if (matched) {
                System.out.println(steps);
                return;
            }

            if (Arrays.equals(pos, start)) {
                System.out.println(-1);
                return;
            }
        }
    }
}
