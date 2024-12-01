import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        
        BigInteger result = BigInteger.valueOf(2).pow(K).subtract(BigInteger.ONE);
        System.out.println(result);
        
        if (K <= 20) {
            func(1, 3, K);
        }
        
        System.out.print(sb);  
    }

    public static void func(int a, int b, int k) {
        if (k == 1) {
            sb.append(a).append(" ").append(b).append("\n");
            return;
        }
        
        func(a, 6 - a - b, k - 1);  
        sb.append(a).append(" ").append(b).append("\n");  
        func(6 - a - b, b, k - 1); 
    }
}
