import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        long count = 0;

        for (int i = 0; i < n - 2; i++) {
            int left = i + 1;
            int right = n - 1;

            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];

                if (sum == 0) {
                    if(arr[left] == arr[right]){
                        int countPairs = right - left + 1;
                        count += (long) countPairs * (countPairs -1) / 2;
                        break;
                    }

                    int leftValue = arr[left];
                    int rightValue = arr[right];
                    int leftCount = 0;
                    int rightCount = 0;

                    while(left < right && arr[left] == leftValue){
                        left++;
                        leftCount++;
                    }
                    while (left <= right && arr[right] == rightValue) {
                        right--;
                        rightCount++;
                    }

                    count += (long) leftCount * rightCount;

                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }

        System.out.println(count);
    }
}
