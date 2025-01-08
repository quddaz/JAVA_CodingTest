import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        int max = 0;
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            int temp = Integer.parseInt(st.nextToken());
            if(max < temp)
                max = temp;
            arr[i] = temp;
        }

        boolean check[] = new boolean[max + 1];

        int end = 0;
        long count = 0;
        for (int i = 0; i < n; i++) {
            while (end < n && !check[arr[end]]) { 
                check[arr[end]] = true;
                end++;
            }
            count += end - i; 
            check[arr[i]] = false;
        }

        System.out.println(count);

    }
}
