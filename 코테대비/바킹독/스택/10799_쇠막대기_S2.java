import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s = new Stack<>();

        int answer = 0;
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            char cnt = str.charAt(i);

            if(cnt == '(') s.push(cnt);
            else{
                s.pop();
                if(str.charAt(i - 1) == '('){
                    answer += s.size();
                }else answer++;
            }
        }

        System.out.println(answer);
    }
}
