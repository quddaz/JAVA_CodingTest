import java.util.*;
import java.io.*;

class Main {
    public static StringBuilder stringbuilder = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        stringbuilder.append((int)(Math.pow(2,K)-1)).append("\n");
        func(1, 3, K);

        System.out.println(stringbuilder);
    }
    public static void func(int a, int b, int n){
        if(n == 1){
            stringbuilder.append(a + " " + b + "\n");
            return;
        }
        func(a, 6-a-b, n-1);
        stringbuilder.append(a + " " + b + "\n");
        func(6-a-b, b, n-1);
    }
}
