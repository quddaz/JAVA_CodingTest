import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        String[] arr1 = br.readLine().split(" ");
        Arrays.sort(arr1); // arr1 정렬

        int m = Integer.parseInt(br.readLine());
        String[] arr2 = br.readLine().split(" ");

        for (String a : arr2) {
            int index = binarySearch(arr1, a);
            String count = (index >= 0) ? "1" : "0";
            bw.write(count + "\n");
        }

        bw.close();
    }

    // 이진 탐색 알고리즘
    private static int binarySearch(String[] arr, String target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int compareResult = target.compareTo(arr[mid]);

            if (compareResult == 0) {
                return mid;
            } else if (compareResult < 0) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }

        return -1;
    }
}