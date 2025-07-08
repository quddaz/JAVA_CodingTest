import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }


        // 카데인 알고리즘
        int cntsum = arr[0];
        int maxsum = arr[0];

        for(int i = 1; i < n; i++){
            cntsum = Math.max(arr[i], cntsum + arr[i]);
            maxsum = Math.max(cntsum, maxsum);
        }

        System.out.println(maxsum);
    }
}

