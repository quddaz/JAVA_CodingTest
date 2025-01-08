import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int a[] = new int[n];
        for(int i = 0; i < n; i++){
            a[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(a);

        int min = Integer.MAX_VALUE;
        int end = 0;
        for(int i = 0; i < n; i++){
            while(end < n && a[end] - a[i] < m) end++;
            if(end == n) break;
            min = Math.min(min, a[end] - a[i]);
        }

        System.out.println(min);
    }
}