import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static Queue<Integer> num = new LinkedList<>();
    static Queue<Character> oper = new LinkedList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        String temp = "";

        for(int i = 0; i < str.length(); i++){
            char cnt = str.charAt(i);
            if(cnt == '-' || cnt == '+'){
                num.add(Integer.parseInt(temp));
                temp = "";
                oper.add(cnt);
            }else{
                temp += cnt;
            }
        }
        num.add(Integer.parseInt(temp));
        
        int result = num.poll();

        while(!num.isEmpty() && !oper.isEmpty()){
            char operator = oper.poll();
            int cnt = num.poll();
            if(operator == '-'){
                while(!oper.isEmpty() && !num.isEmpty()  && oper.peek() == '+'){
                    cnt += num.poll();
                    oper.poll();
                }
                result -= cnt;
            }else{
                result += cnt;
            }
        }

        System.out.println(result);
    }
}
