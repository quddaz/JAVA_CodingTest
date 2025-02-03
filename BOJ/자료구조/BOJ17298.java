import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int arr[] = new int[n];
        int result[] = new int[n];
        Arrays.fill(result, -1);
        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0 ; i < n; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n ; i++){
            while(!s.isEmpty() && arr[s.peek()] < arr[i] ){
                result[s.pop()] = arr[i];
            }
            s.push(i);
        }

        StringBuilder sb = new StringBuilder();
        for(int num : result){
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }
}
