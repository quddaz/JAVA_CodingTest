import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int a[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        int min = Integer.MAX_VALUE;
        int sum = a[0];
        int end = 0;
        for(int i = 0; i < n; i++){
            while(end < n &&sum < m){
                end++;
                if(end != n) sum += a[end];
            }
            if(end == n) break;

            min = Math.min(min, end - i + 1);
            sum -= a[i];
        }
        if(min == Integer.MAX_VALUE)
            System.out.println(0);
        else
            System.out.println(min);
    }
}