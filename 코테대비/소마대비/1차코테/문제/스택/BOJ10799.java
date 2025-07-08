import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Stack<Character> s = new Stack<>();
        String str = br.readLine();

        int result = 0;
        for(int i = 0; i < str.length(); i++){
            char cnt = str.charAt(i);
            if(cnt == '(') s.push(cnt);
            else{
                s.pop();
                if(str.charAt(i - 1) == '('){
                    result += s.size();
                }else{
                    result++;
                }
            }
        }
        System.out.println(result);
    }
}
