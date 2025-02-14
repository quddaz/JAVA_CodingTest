import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int count = 0;
        for (int i = 0; i < n; i++) {
            int cnt = Integer.parseInt(st.nextToken());
            if(count + 1 == cnt){
                count++;
                while(!s.isEmpty() && count + 1 == s.peek()){
                    s.pop();
                    count++;
                }
            }else s.push(cnt);
        }

        System.out.println(count == n ? "Nice" : "Sad");
    }
}
