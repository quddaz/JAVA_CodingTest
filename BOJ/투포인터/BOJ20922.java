import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int map[] = new int[100001];

        int start = 0;
        int end = 0;
        int result = 0;



        while(end < n){
            map[arr[end]]++;

            while (map[arr[end]] > k) {
                map[arr[start]]--;
                start++;
            }
            result = Math.max(result, end - start + 1);
            end++;
        }

        System.out.println(result);
    }
}
