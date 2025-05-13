import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());


        int buttom[] = new int[m + 2];
        int top[] = new int[m + 2];

        for(int i = 1; i <= n; i++){
            int cnt = Integer.parseInt(br.readLine());
            if(i % 2 == 0) top[cnt]++;
            else buttom[cnt]++;
        }

        for(int i = m - 1; i >= 1; i--){
            buttom[i] += buttom[i + 1];
            top[i] += top[i + 1];
        }

        int answer = 0;
        int count = Integer.MAX_VALUE;
        for(int i = 1; i <= m; i++){
            int cnt = buttom[i] + top[m - i + 1];

            if(count > cnt){
                count = cnt;
                answer = 1;
            }else if(count == cnt){
                answer++;
            }
        }

        System.out.println(count + " " + answer);
    }

}
