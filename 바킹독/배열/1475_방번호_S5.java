import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int count[] = new int[10];
        long n = Integer.parseInt(br.readLine());


        while(n > 0){
            int cnt = (int)n % 10;
            count[cnt]++;
            n = n / 10;
        }

        count[6] = (count[9] + count[6] + 1)/2;
        count[9] = 0;
        
        int max = 0;
        for(int i = 0; i < count.length; i++){
            if(max < count[i]){
                max = count[i];
            }
        }

        System.out.println(max);
    }
}
