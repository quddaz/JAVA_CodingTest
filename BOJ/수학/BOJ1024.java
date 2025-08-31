import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        for (int len = L; len <= 100; len++) {
            long temp = N - (long) len * (len - 1) / 2;
            if (temp < 0) break;
            if (temp % len == 0) {
                long start = temp / len;
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < len; i++) {
                    sb.append(start + i).append(" ");
                }
                System.out.println(sb.toString().trim());
                return;
            }
        }
        System.out.println(-1);
    }
}
