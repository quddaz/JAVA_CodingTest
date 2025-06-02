import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        

        String target = br.readLine();
        Stack<Character> s = new Stack<>();

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < target.length(); i++){
            char cnt = target.charAt(i);
            

            if(cnt == '('){
                s.push(cnt);
            }else if(cnt == ')'){
                while(!s.isEmpty() && s.peek() != '('){
                    sb.append(s.pop());
                }

                s.pop();
            }else if(cnt == '+' || cnt == '-'){
                if(!s.isEmpty() && (s.peek() == '*' || s.peek() == '/')){
                    sb.append(s.pop());
                }
                if(!s.isEmpty() && s.peek() != '('){
                    sb.append(s.pop());
                }
                s.push(cnt);
            }else if(cnt == '*' || cnt == '/'){
                if(!s.isEmpty() && (s.peek() == '*' || s.peek() == '/')){
                    sb.append(s.pop());
                }
                s.push(cnt);
            }else{
                sb.append(cnt);
            }
        }

        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        System.out.println(sb);
    }

}

// 스택에 계산식을 넣는다.
// 만약 계산식이 x / 가 나온 후 - +가 나오면 x를 먼저 출력한다. 만약 가로가 나오면 가로 먼저 출력
// 만약 ( 가 나오면 다음 것은 일단 스택에 넣지 않고 출력을 한다. 
