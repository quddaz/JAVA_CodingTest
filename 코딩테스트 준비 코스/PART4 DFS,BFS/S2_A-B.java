import java.io.*;
import java.util.*;

public class S3_16953 {
    static int A,B;
    static int result = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());
        solve(A, 1);

        if(result == Integer.MAX_VALUE){
            System.out.println(-1);
            return;
        }
        System.out.println(result);
    }
    public static void solve(long num, int count){
        if(num == B){
            result = Math.min(result, count);
        }
        if(num > B){
            return;
        }

        solve((num*10)+1, count+1);
        solve(num * 2, count+1);
    }
}

