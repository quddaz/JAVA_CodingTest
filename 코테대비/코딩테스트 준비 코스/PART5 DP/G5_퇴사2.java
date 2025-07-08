import java.io.*;
import java.util.*;

public class G5_15486 {
    static int[][] map;
    static int N;
    static int[] result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][2];
        result = new int[N + 1];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int T = Integer.parseInt(st.nextToken());
            int P = Integer.parseInt(st.nextToken());
            map[i][0] = T;
            map[i][1] = P;
        }

        for (int i = 0; i < N; i++) {
            if (i + map[i][0] <= N) {
                result[i + map[i][0]] = Math.max(result[i + map[i][0]], map[i][1] + result[i]);
            }
            result[i + 1] = Math.max(result[i + 1], result[i]);
        }

        int count = 0;
        for (int i = 0; i <= N; i++) {
            if (result[i] > count) {
                count = result[i];
            }
        }

        System.out.println(count);
    }
}
