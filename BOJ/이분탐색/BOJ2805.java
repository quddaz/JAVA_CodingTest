import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken()); // 나무의 수
        long m = Long.parseLong(st.nextToken()); // 필요한 나무 길이

        int[] trees = new int[n];
        st = new StringTokenizer(br.readLine());
        int max = 0;
        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, trees[i]);
        }

        // 이분 탐색 시작
        long low = 0, high = max;
        long result = 0;

        while (low <= high) {
            long mid = (low + high) / 2;
            long total = 0;

            for (int height : trees) {
                if (height > mid) {
                    total += (height - mid);
                }
            }

            if (total >= m) { // 필요한 나무 길이를 충족할 경우
                result = mid; // 현재 높이 저장
                low = mid + 1; // 더 높은 높이로 탐색
            } else {
                high = mid - 1; // 높이를 낮춰 탐색
            }
        }

        System.out.println(result);
    }
}
