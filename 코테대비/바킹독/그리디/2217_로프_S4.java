import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int map[] = new int[n];

        for(int i = 0; i < n; i++){
            map[i] = Integer.parseInt(br.readLine());
        }


        Arrays.sort(map);
        for(int i = 0 ; i < n; i++){
            map[i] *= (n - i);
        }

        int max = 0;
        for(int i = 0; i < n; i++){
            max = Math.max(max, map[i]);
        }
        System.out.println(max);
    }
}