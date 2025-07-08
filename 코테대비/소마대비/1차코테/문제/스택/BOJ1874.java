import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();
        int idx = 0;
        for(int i = 0; i < n ; i++){
            int cnt = Integer.parseInt(br.readLine());
            if(cnt > idx){
                for(int j = idx + 1; j <= cnt; j++){
                    sb.append("+").append("\n");
                    s.push(j);
                }
                sb.append("-").append("\n");
                s.pop();
                idx = cnt;
            }else{
                if(cnt != s.peek()){
                    System.out.println("NO");
                    return;
                }else{
                    sb.append("-").append("\n");
                    s.pop();
                }

            }
        }
        System.out.println(sb);
    }
}
