import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        long a = Integer.parseInt(st.nextToken());
        long b = Integer.parseInt(st.nextToken());
        long c = Integer.parseInt(st.nextToken());

        System.out.println(solve(a, b, c));
    }

    public static long solve(long a, long b, long c){
        if(b == 0){
            return 1;
        }


        long half = solve(a, b/2, c);

        half = (half * half) % c;

        if(b % 2 == 1)
            half = (half * a) % c;


        return half;
    }
}