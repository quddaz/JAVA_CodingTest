import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b) -> Integer.compare(b, a));
        
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < N; i++) {
            int cnt = Integer.parseInt(br.readLine());
            if(cnt == 0){
                if(!pq.isEmpty()){
                    sb.append(pq.poll()).append("\n");
                }else{
                    sb.append(0).append("\n");
                }
            }else{
                pq.add(cnt);
            }
        }
        
        System.out.println(sb);
    }
}
