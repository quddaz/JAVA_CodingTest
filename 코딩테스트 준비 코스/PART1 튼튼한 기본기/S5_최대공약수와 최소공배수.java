import java.io.*;
import java.util.*;

public class S5_2609 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        System.out.println(GCD(a, b) + "\n" + LCM(a, b));

    }
    public static int GCD(int a, int b){
        while(b != 0){
            int temp = a;
            a = b;
            b = temp % b;
        }
        return a;
    }
    public static int LCM(int a, int b){
        return (a * b) / GCD(a,b);
    }
}
