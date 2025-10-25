import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        long M = Long.parseLong(st.nextToken());

        long[] times = new long[N];
        long maxTime = 0;

        for (int i = 0; i < N; i++) {
            times[i] = Long.parseLong(br.readLine());
            maxTime = Math.max(maxTime, times[i]);
        }

        long left = 1;
        long right = maxTime * M;
        long answer = right;

        while (left <= right) {
            long mid = (left + right) / 2;

            long people = 0;
            for (long t : times) {
                people += mid / t;
                if (people >= M) break; 
            }

            if (people >= M) {
                answer = mid;
                right = mid - 1;
            } else { 
                left = mid + 1;
            }
        }

        System.out.println(answer);
    }
}
