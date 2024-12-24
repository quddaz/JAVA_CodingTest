import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int map[] = new int[n];

        for(int i = 0; i < n; i++)
            map[i] = Integer.parseInt(br.readLine());
        

        int result = 0;
        int idx = n-1;
        while(k != 0 && idx >= 0){
            result += k / map[idx];
            k = k % map[idx--];
        }

        System.out.println(result);
    }
}
