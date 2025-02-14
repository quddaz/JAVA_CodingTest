import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());


        LinkedList<Integer> q = new LinkedList<>();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String cnt = st.nextToken();

            if(cnt.equals("push")){
                int num = Integer.parseInt(st.nextToken());
                q.add(num);
            }else if(cnt.equals("pop")){
                if(q.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(q.poll()).append("\n");
                }
            }else if(cnt.equals("size")){
                sb.append(q.size()).append("\n");
            }else if(cnt.equals("empty")){
                if(q.isEmpty()){
                    sb.append(1).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else if(cnt.equals("front")){
                if(q.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(q.peek()).append("\n");
                }
            }else{
                if(q.isEmpty()){
                    sb.append(-1).append("\n");
                }else{
                    sb.append(q.getLast()).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}
