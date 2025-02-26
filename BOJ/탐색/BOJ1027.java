import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] top = new int[n];
        for (int i = 0; i < n; i++) {
            top[i] = Integer.parseInt(st.nextToken());
        }

        int result = 0;
        for (int i = 0; i < n; i++) {
            int count = 0;
            double maxSlope = 0;
            for (int j = i + 1; j < n; j++) {
                double slope = (double) (top[j] - top[i]) / (j - i);
                if (slope > maxSlope || j == i + 1) {
                    maxSlope = slope;
                    count++;
                }
            }

            maxSlope = 0;
            for (int j = i - 1; j >= 0; j--) {
                double slope = (double) (top[i] - top[j]) / (i - j);
                if (slope < maxSlope || j == i - 1) {
                    maxSlope = slope;
                    count++;
                }
            }

            result = Math.max(result, count);
        }

        System.out.println(result);
    }
}