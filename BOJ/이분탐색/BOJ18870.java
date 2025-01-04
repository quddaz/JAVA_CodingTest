import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        int[] original = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            original[i] = Integer.parseInt(st.nextToken());
        }

        int[] sorted = Arrays.stream(original).distinct().toArray();
        Arrays.sort(sorted);

        for (int value : original) {
            int compressedValue = binarySearch(sorted, value);
            sb.append(compressedValue).append(" ");
        }

        System.out.println(sb.toString().trim());
    }

    private static int binarySearch(int[] sorted, int target) {
        int left = 0, right = sorted.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (sorted[mid] < target) {
                left = mid + 1;
            } else if (sorted[mid] > target) {
                right = mid - 1;
            } else {
                return mid;
            }
        }
        return -1;
    }
}
