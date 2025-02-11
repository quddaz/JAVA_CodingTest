import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int h = Integer.parseInt(st.nextToken());
        int w = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[w];
        for (int i = 0; i < w; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 최대 기둥 위치 찾기
        int maxIdx = 0, maxH = 0;
        for (int i = 0; i < w; i++) {
            if (arr[i] > maxH) {
                maxH = arr[i];
                maxIdx = i;
            }
        }

        int result = 0;

        int leftH = arr[0];
        for (int i = 1; i <= maxIdx; i++) {
            if (arr[i] >= leftH) {
                leftH = arr[i];
            } else {
                result += leftH - arr[i];
            }
        }

        int rightH = arr[w - 1];
        for (int i = w - 2; i >= maxIdx; i--) {
            if (arr[i] >= rightH) {
                rightH = arr[i];
            } else {
                result += rightH - arr[i];
            }
        }

        System.out.println(result);
    }
}
