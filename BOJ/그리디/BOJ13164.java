import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[] a = new long[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) a[i] = Long.parseLong(st.nextToken());

        if (N <= 1 || K >= N) {
            System.out.println(0);
            return;
        }

        long totalRange = a[N-1] - a[0];
        long[] diff = new long[N-1];
        for (int i = 1; i < N; i++) diff[i-1] = a[i] - a[i-1];

        Arrays.sort(diff); // 오름차순
        long remove = 0;
        // 가장 큰 K-1개 더하기
        for (int i = N-2; i >= N-1 - (K-1); i--) {
            remove += diff[i];
        }

        System.out.println(totalRange - remove);
    }
}
