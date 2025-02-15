import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int jem[][] = new int[n][2];
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            jem[i][0] = Integer.parseInt(st.nextToken());
            jem[i][1] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(jem, (a,b) -> a[0] - b[0]);

        int back[] = new int[k];
        for(int i = 0; i < k; i++){
            back[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(back);
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long result = 0;
        int idx = 0;
        for(int ba : back){
            while(idx < n && ba >= jem[idx][0]){
                pq.add(jem[idx][1]);
                idx++;
            }
            
            if(!pq.isEmpty()){
                result += pq.poll();
            }
        }

        System.out.println(result);
    }
}
