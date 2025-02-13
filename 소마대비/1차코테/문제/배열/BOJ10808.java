import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int[] arr = new int[26];

        for(int i = 0; i < str.length(); i++){
            char cnt = str.charAt(i);
            arr[cnt - 'a'] += 1;
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < arr.length; i++){
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);
    }
}
