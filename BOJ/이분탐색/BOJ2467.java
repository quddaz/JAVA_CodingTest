import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] arr;
    static int result = Integer.MAX_VALUE;
    static int left, right;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr); 
        int start = 0;
        int end = n - 1;

        while(start < end){
            int sum = arr[start] + arr[end];

            if(Math.abs(sum) < result){
                result = Math.abs(sum);
                left = arr[start];
                right = arr[end];
            }

            if(sum < 0){
                start++;
            }else{
                end--;
            }
        }

        System.out.println(left + " " + right);
    }
}
