import java.util.*;
import java.io.*;
 
class Solution
{
    static String password;
    static int length;
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 10; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            length = Integer.parseInt(st.nextToken());
            password = st.nextToken();
             
            Stack<Character> stack = new Stack<>();
            for(int j = 0; j <length; j++){
                char target = password.charAt(j);
                 
                if(!stack.isEmpty() && stack.peek() == target)
                    stack.pop();
                else
                    stack.push(target);
            }
             
            StringBuilder result = new StringBuilder();
            while (!stack.isEmpty()) {
                result.append(stack.pop());
            }
             
            System.out.println("#" + i + " " + result.reverse().toString());
        }
    }
     
}