import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int b = Integer.parseInt(br.readLine());
        int c = Integer.parseInt(br.readLine());

        long num = a * b * c;
        int arr[] = new int[10];
        while(num > 0){
            int cnt = (int)num % 10;
            arr[cnt]++;
            num = num / 10;
        }

        StringBuilder sb = new StringBuilder();
        for(int n : arr){
            sb.append(n).append('\n');
        }
        System.out.println(sb);
    }
}
