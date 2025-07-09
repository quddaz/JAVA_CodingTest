import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> s = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while(true){
            String cnt = br.readLine();
            if(cnt.equals(".")) break;

            s.clear();
            boolean flag = true;
            for(char c : cnt.toCharArray()){
                if(c == '(' || c == '[')s.add(c);
                else if(c == ')'){
                    if (s.isEmpty() || s.peek() != '('){
                        flag = false;
                        break;
                    } 
                    s.pop();
                }
                else if(c == ']'){
                    if (s.isEmpty() || s.peek() != '['){
                        flag = false;
                        break;
                    }
                    s.pop();
                }
            }
            if(!s.isEmpty()) flag = false;
            sb.append(flag ? "yes" : "no").append("\n");
        }

        System.out.println(sb);
    }
}
