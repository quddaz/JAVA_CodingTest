import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));
        int maxH = 0, maxIdx = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i][1] > maxH) {
                maxH = arr[i][1];
                maxIdx = i;
            }
        }

        int area = 0;

        int leftH = arr[0][1];
        int leftX = arr[0][0];
        for (int i = 1; i <= maxIdx; i++) {
            if (arr[i][1] >= leftH) {
                area += (arr[i][0] - leftX) * leftH;
                leftH = arr[i][1];
                leftX = arr[i][0];
            }
        }

        int rightH = arr[n - 1][1];
        int rightX = arr[n - 1][0];
        for (int i = n - 2; i >= maxIdx; i--) {
            if (arr[i][1] >= rightH) {
                area += (rightX - arr[i][0]) * rightH;
                rightH = arr[i][1];
                rightX = arr[i][0];
            }
        }

        area += maxH;

        System.out.println(area);
    }
}
