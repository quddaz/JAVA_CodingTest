import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        int[] hunters = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            hunters[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(hunters);

        int answer = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); // x
            int b = Integer.parseInt(st.nextToken()); // y

            // y가 사정거리보다 더 크면 절대 못 잡음
            if (b > L) continue;

            int idx = Arrays.binarySearch(hunters, a);

            if (idx < 0) {
                idx = -idx - 1; 
            }

            boolean catchable = false;

            if (idx < M) {
                if (Math.abs(hunters[idx] - a) + b <= L) {
                    catchable = true;
                }
            }

            if (!catchable && idx - 1 >= 0) {
                if (Math.abs(hunters[idx - 1] - a) + b <= L) {
                    catchable = true;
                }
            }

            if (catchable) answer++;
        }

        System.out.println(answer);
    }
}
