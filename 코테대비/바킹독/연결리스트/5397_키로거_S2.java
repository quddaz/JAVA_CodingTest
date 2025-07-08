import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        while(t-- > 0){

            Stack<Character> left = new Stack<>();
            Stack<Character> right = new Stack<>();

            String str = br.readLine();

            for(int i = 0; i < str.length(); i++){
                char cnt = str.charAt(i);

                if(cnt == '<'){
                    if(!left.isEmpty())
                        right.push(left.pop());
                }else if(cnt == '>'){
                    if(!right.isEmpty())
                        left.push(right.pop());
                }else if(cnt == '-'){
                    if(!left.isEmpty())
                        left.pop();
                }else{
                    left.push(cnt);
                }
            }

            for(char c : left) sb.append(c);
            while(!right.isEmpty()) sb.append(right.pop());
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
