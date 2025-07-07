import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int top[] = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            top[i] = Integer.parseInt(st.nextToken());
        }


        Stack<int[]> s = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            while(!s.isEmpty() && s.peek()[0] < top[i]) s.pop();
            
            if(!s.isEmpty()){
                sb.append(s.peek()[1] + 1).append(" ");
            }else{
                sb.append(0).append(" ");
            }

            s.push(new int[]{top[i], i});
        }
        System.out.println(sb);
    }
}
