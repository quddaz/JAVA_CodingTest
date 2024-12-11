import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i < n; i++){
            pq.add(Integer.parseInt(br.readLine()));
        }

        if(n == 1){
            System.out.println(0);
            return;
        }
        int result = 0;
        while(!pq.isEmpty()){
            int first = pq.poll();
            int second = pq.poll();
            int sum = first + second;
            result += sum;
            if(pq.isEmpty()) break;
            pq.add(sum);
        }
        System.out.println( result);
    }

}
