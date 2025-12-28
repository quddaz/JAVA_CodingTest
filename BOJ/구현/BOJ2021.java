import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] a = new int[N];
        long[] ps = new long[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            a[i] = Integer.parseInt(st.nextToken());
            ps[i] = a[i] + (i > 0 ? ps[i - 1] : 0);
        }

        long total = ps[N - 1];
        long ans = 0;

        for (int i = 1; i <= N - 2; i++) {
            long cur = (total - a[0]) + (total - ps[i]) - a[i];
            ans = Math.max(ans, cur);
        }

        for (int i = 1; i <= N - 2; i++) {
            long cur = (total - a[N - 1]) + ps[i - 1] - a[i];
            ans = Math.max(ans, cur);
        }

        for (int i = 1; i <= N - 2; i++) {
            long cur = (ps[i] - a[0]) + (total - ps[i - 1] - a[N - 1]);
            ans = Math.max(ans, cur);
        }

        System.out.println(ans);
    }
}
