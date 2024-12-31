import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[][] box = new int[m][3];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            box[i][0] = Integer.parseInt(st.nextToken());
            box[i][1] = Integer.parseInt(st.nextToken());
            box[i][2] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(box, (a, b) -> {
            if (a[1] == b[1]) {
                return a[0] - b[0];
            }
            return a[1] - b[1];
        });

        int[] truck = new int[n + 1];
        int sum = 0;

        for (int[] bo : box) {
            int from = bo[0];
            int to = bo[1];
            int load = bo[2];

            int maxLoad = load;
            for (int i = from; i < to; i++) {
                maxLoad = Math.min(maxLoad, c - truck[i]);
            }

            for (int i = from; i < to; i++) {
                truck[i] += maxLoad;
            }

            sum += maxLoad;
        }

        System.out.println(sum);
    }
}
