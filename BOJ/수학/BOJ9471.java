import java.io.*;
import java.util.*;

public class Main {

    static final int LIMIT = 2_000_000; //해당 문제는 최대가 1백만 즉 피사노 150만이다.
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(n-- > 0){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            sb.append(num).append(" ").append(getPisano(m)).append("\n");
        }
        System.out.println(sb);
    }


    //피사노 주기는 피보나치 수열을 m으로 나눌 때 나머지가 주기를 이룬다는 것이다.
    //이 점을 이용해 초기 0과 1은 고정이므로 다음에 0과 1이되는 횟수가 피사노 주기이다.
    public static int getPisano(int m){
        int prev = 0;
        int curr = 1;
        int pisano = 0;
        
        for(int i = 0; i < LIMIT; i++){
            int temp = (prev + curr) % m;
            prev = curr;
            curr = temp;
            pisano++;

            if(prev == 0 && curr == 1){
                return pisano;
            }
        }
        return pisano;
    }
}
