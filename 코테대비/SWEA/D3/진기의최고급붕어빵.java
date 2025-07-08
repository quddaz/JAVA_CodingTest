import java.util.*;
import java.io.*;
 
class Solution
{
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int i = 1; i <= T; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
             
            st = new StringTokenizer(br.readLine());
            PriorityQueue<Integer> pq = new PriorityQueue<>();
            for(int x = 0; x < N; x++){
                int time = Integer.parseInt(st.nextToken());
                pq.add(time);
            }
             
            int time = 0;
            int bread = 0;
            boolean result = true;
            while(!pq.isEmpty()){
                int target = pq.poll();
                 
                while(time < target){
                    time++;
                    if(time % M == 0)
                        bread += K;
                }
                 
                if(target > 0 && bread > 0)
                    bread--;
                else{
                    result = false;
                    break;
                }
            }
            if (result) {
                System.out.println("#" + i + " Possible");
            } else {
                System.out.println("#" + i + " Impossible");
            }
 
        }
    }
}