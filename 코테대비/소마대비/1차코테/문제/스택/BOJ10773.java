import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < n; i++){
            int cnt = Integer.parseInt(br.readLine());
            if(cnt == 0){
                s.pop();
            }else{
                s.push(cnt);
            }
        }

        int sum = 0;
        while(!s.isEmpty()){
            sum += s.pop();
        }

        System.out.println(sum);
    }
}
