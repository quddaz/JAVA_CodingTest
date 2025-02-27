import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());

        long[] arr = new long[k];

        for(int i = 0; i < k; i++){
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        long left = 1;
        long right = arr[k-1];
        long result = 0;
        
        while(left <= right){
            long mid = (left + right) / 2;
            long count = 0;
            for(long length: arr){
                count += length / mid;
            }

            if(count >= n){
                result = mid;
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
        }
        System.out.println(result);
    }
}
