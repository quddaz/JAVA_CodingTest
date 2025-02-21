import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        boolean[] isPrime = new boolean[n + 1];
        int count = 0;

        for (int i = 2; i <= n; i++) {
            if (!isPrime[i]) { 
                for (int j = i; j <= n; j += i) {
                    if (!isPrime[j]) { 
                        isPrime[j] = true;
                        count++;
                        if (count == k) {
                            System.out.println(j);
                            return;
                        }
                    }
                }
            }
        }
    }
}
