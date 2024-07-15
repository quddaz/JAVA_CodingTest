import java.io.*;
import java.util.*;

public class B1_1292{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken()); 
        int B = Integer.parseInt(st.nextToken()); 
        List<Integer> arr = new ArrayList<>();

        int count = 1;
        while(arr.size() <= B){
            for(int i = 0; i < count; i++){
                arr.add(count);
            }
            count++;
        }

        int result = 0;
        for(int i = A-1; i < B; i++){
            result += arr.get(i);
        }
        System.out.println(result);
    }
}
