import java.io.*;
import java.util.*;

class Main {
    static boolean isPrime[];

    public static void solve(int n){
        isPrime = new boolean[n+1];

        isPrime[0] = isPrime[1] = true;

        for(int i = 2; i <= Math.sqrt(n); i++){
            if(!isPrime[i])
                for(int j = i * i; j <=n; j += i){
                    isPrime[j] = true;
                }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st= new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.paserInt(st.nextToken());
        solve(n);

        for(int i = m; i < n+1; i++){
            if(!isPrime[i])
                System.out.println(i);
        }
    }
}