import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());


        String num = br.readLine();
        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < n; i++){
            int cnt = num.charAt(i) - '0';

            while(!s.isEmpty() && k > 0 && s.peek() < cnt){
                k--;
                s.pop();
            }

            s.push(cnt);
        }

        while(k > 0){
            k--;
            s.pop();
        }

        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }

        sb.reverse();
        System.out.println(sb);

    }


}
