import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Integer> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String flag = st.nextToken();
            
            if(flag.equals("push")){
                int cnt = Integer.parseInt(st.nextToken());
                s.push(cnt);
            }else if(flag.equals("pop")){
                if(s.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(s.pop()).append("\n");
                }
            }else if(flag.equals("size")){
                sb.append(s.size()).append("\n");
            }else if(flag.equals("empty")){
                if(s.isEmpty()){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else{
                if(s.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(s.peek()).append("\n");
                }
            }
        }
        System.out.println(sb);

    }
}