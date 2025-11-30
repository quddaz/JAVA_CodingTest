import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int max = 0;
        long sum = 0;

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            sum += arr[i];
            max = Math.max(max, arr[i]);
        }

        int M = Integer.parseInt(br.readLine());

        // 모든 요청을 그대로 줄 수 있으면 최대 요청값 출력
        if (sum <= M) {
            System.out.println(max);
            return;
        }

        // 이분 탐색
        int left = 0;
        int right = max;
        int result = 0;

        while (left <= right) {
            int mid = (left + right) / 2;

            long allocated = 0;
            for (int i = 0; i < N; i++) {
                allocated += Math.min(arr[i], mid);
            }

            if (allocated <= M) {
                result = mid;    // 가능한 상한액
                left = mid + 1;  // 더 높여보기
            } else {
                right = mid - 1; // 너무 초과하면 낮추기
            }
        }

        System.out.println(result);
    }
}
