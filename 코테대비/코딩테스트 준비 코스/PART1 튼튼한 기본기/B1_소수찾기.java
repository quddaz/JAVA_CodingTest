import java.io.*;
import java.util.*;

public class B1_1978{
    static boolean[] isPrime;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()); 
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[N]; 
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); 
        }


        int maxNum = Arrays.stream(arr).max().getAsInt();
        isPrime = new boolean[maxNum + 1]; 


        sieveOfEratosthenes(maxNum);

        int count = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] >= 2 && !isPrime[arr[i]]) { 
                count++;
            }
        }

        System.out.println(count);
    }

    // 에라토스테네스의 체 알고리즘 구현
    public static void sieveOfEratosthenes(int maxNum) {
        isPrime[0] = isPrime[1] = true; 

        for (int i = 2; i <= Math.sqrt(maxNum); i++) {
            if (!isPrime[i]) {
                for (int j = i * i; j <= maxNum; j += i) {
                    isPrime[j] = true; 
                }
            }
        }
    }
}
