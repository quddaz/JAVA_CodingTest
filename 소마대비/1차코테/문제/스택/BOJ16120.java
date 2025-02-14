import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String st = br.readLine();
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < st.length(); i++){
            char cnt = st.charAt(i);

            if(!s.isEmpty() && cnt == 'P' && s.peek() == 'A'){
                s.pop();
                for(int x = 0; x < 2; x++){
                    if(s.isEmpty() ||s.pop() != 'P'){
                        System.out.println("NP");
                        return;
                    }
                }
                s.push('P');
            }else{
                s.push(cnt);
            }
        }
        System.out.println(s.size() == 1 && s.peek() == 'P' ?"PPAP" : "NP");
    }
}
