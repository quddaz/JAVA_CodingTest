import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int arr[] = new int[n + 1];

        for(int i = 0; i < n; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        arr[n] = Integer.MAX_VALUE;
        Stack<int[]> s=  new Stack<>();
        long result = 0;
        for(int i = 0; i <= n; i++){
            while(!s.isEmpty() && s.peek()[0] <= arr[i]){
                result += i-s.pop()[1] - 1;
            }
            s.push(new int[]{arr[i],i});
        }
        System.out.println(result);
    }

}
