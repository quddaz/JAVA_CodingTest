import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> al = findPrimes(n);

        int count = 0;
        int start = 0;
        int end = 0;
        int sum = 0;

        while (start < al.size()) {
            if (sum >= n) {
                if (sum == n) {
                    count++;
                }
                sum -= al.get(start++);
            } else {
                if (end < al.size()) {
                    sum += al.get(end++);
                } else {
                    break; 
                }
            }
        }

        System.out.println(count);
    }
    public static List<Integer> findPrimes(int n){
        List<Integer> primeList = new ArrayList<>();

        boolean[] isPrime = new boolean[n+1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;

        for(int i = 2; i * i <= n; i++){
            if(isPrime[i]) {
                for(int j = i * i; j <= n; j += i){
                    isPrime[j] = false;
                }
            }
        }
        for (int i = 2; i <= n; i++) {
            if (isPrime[i]) {
                primeList.add(i); 
            }
        }
        return primeList;
    }
}
