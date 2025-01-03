import java.io.*;
import java.util.*;


public class Main {
    static int n;
    static int sum[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        sum = new int[n * (n + 1) / 2];
        int idx = 0;

        for(int i = 0; i < n; i++){
            for(int j = i; j < n; j++){
                sum[idx++] = arr[i] + arr[j];
            }
        }
        Arrays.sort(sum);

        int max = -1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int sums = arr[i] - arr[j];
                if (solve(sums)) {
                    max = Math.max(max, arr[i]);
                }
            }
        }

        System.out.println(max);
    }
    public static boolean solve(int num){
        int left = 0;
        int right = sum.length - 1;

        while(left <= right){
            int mid = (left + right) /2;

            if(sum[mid] == num)
                return true;
            else if(sum[mid] < num)
                left = mid + 1;
            else
                right = mid - 1;
        }
        
        return false;
    }
  
}

