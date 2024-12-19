import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        // 증가 DP
        int[] inc = new int[N];
        Arrays.fill(inc, 1);
        for (int i = 1; i < N; i++) {
            for (int j = 0; j < i; j++) {
                if (A[i] > A[j]) {
                    inc[i] = Math.max(inc[i], inc[j] + 1);
                }
            }
        }

        // 감소 DP
        int[] dec = new int[N];
        Arrays.fill(dec, 1);
        for (int i = N - 2; i >= 0; i--) {
            for (int j = N - 1; j > i; j--) {
                if (A[i] > A[j]) {
                    dec[i] = Math.max(dec[i], dec[j] + 1);
                }
            }
        }

        // 바이토닉 길이 계산
        int maxLength = 0;
        for (int i = 0; i < N; i++) {
            maxLength = Math.max(maxLength, inc[i] + dec[i] - 1);
        }

        System.out.println(maxLength);
    }
}
