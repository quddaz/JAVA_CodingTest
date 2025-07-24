import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static boolean flag= false;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        dfs("");

    }

    static void dfs(String str){
        if(flag) return;

        if(!isGood(str)) return;

        if(str.length() == N){
            flag = true;
            System.out.println(str);
            return;
        }

        for(int i = 1; i <= 3; i++){
            dfs(str + i);
        }
    }

    static boolean isGood(String str){
        int len = str.length();

        for(int size = 1; size <= len / 2; size++){
            String s1 = str.substring(len - 2 * size, len - size);
            String s2 = str.substring(len - size);

            if(s1.equals(s2)) return false;
        }

        return true;
    }
}
