import java.io.*;
import java.util.*;

public class B3_2460 {
    static int STATION_COUNT = 10;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int result = 0;
        int max = 0; 
        for(int i = 0; i < STATION_COUNT; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            int out = Integer.parseInt(st.nextToken());
            int in = Integer.parseInt(st.nextToken());  
            result = result + in - out;
            max = Math.max(max, result);
        }
        System.out.println(max);
    }
}