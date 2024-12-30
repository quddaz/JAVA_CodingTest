import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] arr;

    static void solve() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        arr = new long[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(arr); // 배열 정렬

        long min = Long.MAX_VALUE; // 최소 합의 절대값
        long[] res = new long[3]; // 결과 저장 배열

        // 첫 번째 용액 고정
        for (int i = 0; i < N - 2; i++) {
            int lo = i + 1;
            int hi = N - 1;

            // 투 포인터로 두 용액 탐색
            while (lo < hi) {
                long sum = arr[i] + arr[lo] + arr[hi];

                // 최소합 갱신
                if (Math.abs(sum) < min) {
                    min = Math.abs(sum);
                    res[0] = arr[i];
                    res[1] = arr[lo];
                    res[2] = arr[hi];
                }

                // 합에 따라 포인터 이동
                if (sum < 0) {
                    lo++;
                } else if (sum > 0) {
                    hi--;
                } else { // 합이 정확히 0인 경우
                    bw.write(arr[i] + " " + arr[lo] + " " + arr[hi] + "\n");
                    bw.flush();
                    return;
                }
            }
        }

        // 결과 출력 (이미 정렬된 상태)
        Arrays.sort(res);
        for (int i = 0; i < 3; i++) {
            bw.write(res[i] + " ");
        }
        bw.flush();
    }

    public static void main(String[] args) throws IOException {
        solve();
    }
}
