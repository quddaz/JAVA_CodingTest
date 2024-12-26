import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        PriorityQueue<Long> pq = new PriorityQueue<>();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            pq.add(Long.parseLong(st.nextToken()));
        }

        for(int i = 0; i < m; i++){
            Long temp = pq.poll() + pq.poll();
            pq.add(temp);
            pq.add(temp);
        }

        long result = 0;
        while(!pq.isEmpty()){
            result += pq.poll();
        }

        System.out.println(result);
    }
}
