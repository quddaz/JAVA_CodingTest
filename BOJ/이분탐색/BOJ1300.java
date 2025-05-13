import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        long left = 1;
        long right = (long) n * n;
        long answer = 0;

        while(left <= right){
            long mid = (left + right) / 2;

            long count = 0;
            for(int i = 1; i <= n; i++){
                count += Math.min(mid / i, n);
            }

            if(count >= m){
                right = mid - 1;
                answer = mid;
            }else{
                left = mid + 1;
            }
        }
        System.out.println(answer);
    }

}
