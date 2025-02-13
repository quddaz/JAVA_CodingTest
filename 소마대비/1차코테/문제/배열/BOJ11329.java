import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < n; i++){
            st = new StringTokenizer(br.readLine());
            String a = st.nextToken();
            String b = st.nextToken();

            int arr[] = new int[26];

            for(char c : a.toCharArray()){
                arr[c - 'a']++;
            }

            for(char c : b.toCharArray()){
                arr[c - 'a']--;
            }
            
            boolean flag = true;
            for(int num : arr){
                if(Math.abs(num) != 0){
                    flag = false;
                    sb.append("Impossible").append('\n');
                    break;
                }
            }
            if(flag){
                sb.append("Possible").append('\n');
            }
        }
        System.out.println(sb);
    }
}
