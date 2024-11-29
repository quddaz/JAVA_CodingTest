import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> stack = new Stack<>();
        int result = 0;

        char[] str = br.readLine().toCharArray();
        int temp = 1;

        for (int i = 0; i < str.length; i++) {
            if (str[i] == '(') {
                stack.push('(');
                temp *= 2;
            } else if (str[i] == '[') {
                stack.push('[');
                temp *= 3;
            } else {
                if (stack.isEmpty()) {
                    result = 0;
                    break;
                }

                char top = stack.pop();
                if ((str[i] == ')' && top != '(') || (str[i] == ']' && top != '[')) {
                    result = 0;
                    break;
                }

                if ((str[i] == ')' && str[i - 1] == '(') || (str[i] == ']' && str[i - 1] == '[')) {
                    result += temp;
                }
                temp /= (str[i] == ')') ? 2 : 3;
            }
        }

        if (!stack.isEmpty()) {
            result = 0;
        }

        System.out.println(result);
    }
}

