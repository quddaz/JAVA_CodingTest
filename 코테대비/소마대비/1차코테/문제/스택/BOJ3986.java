import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb = new StringBuilder();
    static Stack<Character> s = new Stack<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int count = 0;
        for(int i = 0; i < n; i++){
            String cnt = br.readLine();
            s.clear();

            for(char c : cnt.toCharArray()){
                if(!s.isEmpty() && s.peek() == c) s.pop();
                else s.push(c);
            }

            if(s.isEmpty()) count++;
        }

        System.out.println(count);
    }
}
