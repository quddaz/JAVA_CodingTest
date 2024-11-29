import java.util.*;
import java.io.*;

class Main {
    static Stack<Character> s;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String str = br.readLine();

            if(str.equals(".")) break;

            s = new Stack<>();

            boolean isValid = true;

            for(int i = 0; i < str.length(); i++){
                char cnt = str.charAt(i);
                if(cnt == '(' || cnt == '[')
                    s.add(cnt);
                else if(cnt == ')' || cnt == ']'){
                    if (s.isEmpty()) {
                        isValid = false;
                        break;
                    }
                    char top = s.pop();
                    if ((cnt == ')' && top != '(') || (cnt == ']' && top != '[')) {
                        isValid = false;
                        break;
                    }
                }
            }
            if(!s.isEmpty()){
                isValid = false;
            }
            System.out.println(isValid ? "yes" : "no");
        }
    }

}
