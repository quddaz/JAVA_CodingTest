
import java.io.*;
import java.util.*;
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        String bomb = br.readLine();

        Stack<Character> s = new Stack<>();
        
        for(char c : str.toCharArray()){
            s.add(c);

            if(s.size() >= bomb.length()){
                boolean isBomb = true;
                for(int i = 0; i < bomb.length(); i++){
                    if(s.get(s.size() - bomb.length() + i) != bomb.charAt(i)){
                        isBomb = false;
                        break;
                    }
                }

                if(isBomb){
                    for(int i = 0; i < bomb.length(); i++){
                        s.pop();
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for(char c : s){
            sb.append(c);
        }

        if(sb.length() == 0){
            System.out.println("FRULA");
        }else
            System.out.println(sb.toString());
    }
}
