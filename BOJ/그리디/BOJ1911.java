import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[][] ponds = new int[N][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            ponds[i][0] = Integer.parseInt(st.nextToken());
            ponds[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(ponds, (a, b) -> Integer.compare(a[0], b[0]));

        int result = 0;
        int cur = 0;

        for (int i = 0; i < N; i++) {
            int start = Math.max(ponds[i][0], cur);
            int end = ponds[i][1];

            if (start < end) {
                int len = end - start;
                int count = (len + L - 1) / L;
                result += count;
                cur = start + count * L;
            }
        }

        System.out.println(result);
    }
}
