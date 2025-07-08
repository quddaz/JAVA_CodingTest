import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int a = Integer.parseInt(br.readLine());
        int arr[] = new int[a];
        int result[] = new int[a];

        Arrays.fill(result, -1);

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < a; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Stack<Integer> s = new Stack<>();
        for(int i = a - 1; i >= 0; i--){
            while(!s.isEmpty() && s.peek() <= arr[i]){
                s.pop();
            }
            if(!s.isEmpty()){
                result[i] = s.peek();
            }
            s.push(arr[i]);
        }
        StringBuilder sb = new StringBuilder();
        for(int num : result){
            sb.append(num).append(" ");
        }

        System.out.println(sb);
    }

}
