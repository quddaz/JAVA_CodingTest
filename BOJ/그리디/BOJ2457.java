import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static int START = 301;
    static int END = 1201;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int map[][] = new int[n][2];

        for(int i = 0; i < n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            map[i][0] = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());
            map[i][1] = Integer.parseInt(st.nextToken()) * 100 + Integer.parseInt(st.nextToken());            
        }
        
        Arrays.sort(map, (a,b) ->{
            if(a[0] == b[0]){//지는 기준 내림차순
                return b[1] - a[1];
            }//피는 기준 오름차순
            return a[0] - b[0];
        });

        int idx = 0;
        int result = 0;
        int cntEnd = START;
        int maxEnd = START;

        while(cntEnd < END){
            boolean flag = false;
            while(idx < n && map[idx][0] <= cntEnd){
                maxEnd = Math.max(maxEnd, map[idx][1]);
                idx++;
                flag = true;
            }
            if(!flag){
                System.out.println(0);
                return;
            }

            cntEnd = maxEnd;
            result++;
        }
        System.out.println(result);
    }
}
