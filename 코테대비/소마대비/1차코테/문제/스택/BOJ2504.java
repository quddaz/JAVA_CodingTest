import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        String str = br.readLine();
        
        int result = 0, temp = 1;
        
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            
            if (c == '(' || c == '[') {
                stack.push(c);
                temp *= (c == '(') ? 2 : 3;
            } else {
                if (stack.isEmpty() || 
                   (c == ')' && stack.peek() != '(') || 
                   (c == ']' && stack.peek() != '[')) {
                    result = 0;
                    break;
                }

                if ((c == ')' && str.charAt(i - 1) == '(') || 
                    (c == ']' && str.charAt(i - 1) == '[')) {
                    result += temp;
                }
                
                temp /= (c == ')') ? 2 : 3;
                stack.pop();
            }
        }
        
        System.out.println(stack.isEmpty() ? result : 0);
    }
}
