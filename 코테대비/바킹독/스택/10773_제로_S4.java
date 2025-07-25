import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();

        for(int i = 0; i < K; i++){
            int n = Integer.parseInt(br.readLine());
            if(n == 0){
                if(!s.isEmpty())
                    s.pop();
            }else{
                s.push(n);
            }
        }

        int answer = 0;
        for(int num : s) answer += num;

        System.out.println(answer);
    }
}
