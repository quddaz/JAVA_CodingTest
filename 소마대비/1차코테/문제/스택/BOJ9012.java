import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> s = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        for(int i = 0; i < n; i++){
            String cnt = br.readLine();
            s.clear();

            for(char c : cnt.toCharArray()){
                if(c == '(') s.push(c);
                else{
                    if(s.isEmpty()){
                        s.push(c);
                        break;
                    }
                    if(s.peek() == '(') s.pop();
                    else s.push(c);
                }
            }

            sb.append(s.isEmpty() ? "YES" : "NO").append("\n");
        }

        System.out.println(sb);
    }
}
