import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        PriorityQueue<Integer> pos = new PriorityQueue<>((a,b) -> b - a);
        PriorityQueue<Integer> neg = new PriorityQueue<>((a,b) -> a - b);

        int zero = 0;
        for(int i = 0 ; i < n; i++){
            int cnt = Integer.parseInt(br.readLine());
            if(cnt == 0)
                zero++;
            else if(cnt > 0)
                pos.add(cnt);
            else
                neg.add(cnt);
        }

        long result = 0;
        while(pos.size() >= 2){
            int a = pos.poll();
            int b = pos.poll();
            if(a * b > a + b)
                result += a * b;
            else
                result += a + b;
        }
        while(neg.size() >= 2){
            result += neg.poll() * neg.poll();
        }

        if(!pos.isEmpty())
            result += pos.poll();
        
        if(!neg.isEmpty()){
            if(zero > 0){
                zero--;
            }else{
                result += neg.poll();
            }
        }

        System.out.println(result);
    }
}
