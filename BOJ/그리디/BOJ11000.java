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
        int n = Integer.parseInt(br.readLine());
        int map[][] = new int[n][2];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(map, (a, b) ->  Integer.compare(a[0], b[0]));

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        pq.add(map[0][1]);

        for(int i = 1; i < n; i++){
            if(map[i][0] >= pq.peek()){
                pq.poll();
            }
            pq.add(map[i][1]);
        }

        System.out.println(pq.size());
    }
}
