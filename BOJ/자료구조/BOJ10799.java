import java.util.*;
import java.io.*;

class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s = new Stack<>();
        int result = 0;
        String str = br.readLine();

        for(int i = 0; i < str.length(); i++){
            char cnt = str.charAt(i);
            if(cnt == '(')
                s.add(cnt);
            else{
                s.pop();
                if(str.charAt(i - 1) == '(')
                    result += s.size();
                else
                    result++;
            }
        }
        System.out.println(result);
    }

}
