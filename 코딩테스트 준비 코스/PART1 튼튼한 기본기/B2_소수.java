import java.io.*;
import java.util.*;

public class B2_2581 {
    static boolean isPrime[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine()); 
        int N = Integer.parseInt(br.readLine()); 

        isPrime_fun(N);

        int sum = 0;
        for(int i = M; i <= N; i++){
            if(!isPrime[i]) sum += i;
        }
        if(sum == 0){
            System.out.println(-1);
            return;
        }
        System.out.println(sum);
        for(int i = M; i <= N; i++){
            if(!isPrime[i]){
                System.out.println(i);
                break;
            }
        }
    }

    public static void isPrime_fun(int n){
        isPrime = new boolean[n+1];
        isPrime[0] = isPrime[1] = true;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(!isPrime[i]){
                for(int j = i * i; j <= n; j += i){
                    isPrime[j] = true;
                }
            }
        }
    }
}
