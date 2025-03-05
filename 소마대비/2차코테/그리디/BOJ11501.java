import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(br.readLine());

        while(test-- > 0){
            int n = Integer.parseInt(br.readLine());
            int arr[] = new int[n];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < n; i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }

            long max = 0;
            long result = 0;
            for(int i = n - 1; i >= 0 ; i--){
                if(arr[i] < max){
                    result += max - arr[i];
                }else{
                    max = arr[i];
                }
            }

            System.out.println(result);
        }
    }
}
