import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[][] = new int[n][2];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }


        Arrays.sort(arr, (a,b) -> a[0] - b[0]);

        int start = arr[0][0];
        int end = arr[0][1];
        long result = 0;

        for(int i = 1; i < n;i++){
            if(arr[i][0] > end){
                result += end - start;
                start = arr[i][0];
                end = arr[i][1];
            }else{
                if(end < arr[i][1])
                    end = arr[i][1];
            }
        }

        result += end - start;
        System.out.println(result);
    }
}
