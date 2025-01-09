import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        int count[] = new int[d + 1];
        int cnt = 0;

        for(int i = 0; i < k; i++){
            if(count[arr[i]] == 0) cnt++;
            count[arr[i]]++;
        }
        
        int result = cnt;
        if(count[c]==0) result++;

        for(int i = 1; i < n; i++){
            int prev = arr[(i-1) % n];
            count[prev]--;
            if(count[prev] == 0) cnt--;

            int next = arr[(i+k - 1) % n];
            if(count[next] == 0) cnt++;
            count[next]++;

            result = Math.max(result, cnt + (count[c] == 0 ? 1 : 0));
        }

        System.out.println(result);
    }
}
