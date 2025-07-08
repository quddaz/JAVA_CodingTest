import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());;

        Stack<Integer> s = new Stack<>();
        int target = 0;
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < K; i++){
            int cnt = Integer.parseInt(br.readLine());
            if(cnt > target){
                for(int x = target + 1; x <= cnt; x++){
                    sb.append("+").append("\n");
                    s.push(x);
                }
                sb.append("-").append("\n");
                s.pop();
                target = cnt;
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
