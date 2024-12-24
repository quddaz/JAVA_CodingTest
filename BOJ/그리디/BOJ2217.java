import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        int arr[] = new int[n];
        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(arr);
        for(int i = 0; i < n; i++){
            arr[i] *= (n-i);
        }
        int max = 0;
        for(int i = 0; i < n; i++){
            if(arr[i] > max)
                max = arr[i];
        }

        System.out.println(max);
    }
}
