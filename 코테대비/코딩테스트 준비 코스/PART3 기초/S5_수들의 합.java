import java.io.*;
import java.util.*;

public class S5_1789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());
        System.out.println(solve(N));

    }
    public static int solve(long n){
        long sum = 0;
        int num = 0;
        while(n >= sum){
            sum += (++num);
        }
        return sum == n ? num : num-1;
    }
}
