import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Character> s = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            String str = br.readLine();
            s.clear();

            for(char c : str.toCharArray()){
                if(!s.isEmpty() && s.peek() == '(' && c == ')') s.pop();
                else s.push(c);
            }

            if(s.isEmpty()) sb.append("YES").append("\n");
            else sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }
}
