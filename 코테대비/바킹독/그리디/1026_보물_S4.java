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

        Integer[] map1 = new Integer[n];
        Integer[] map2 = new Integer[n];

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++){
            map1[i] = Integer.parseInt(st1.nextToken());
            map2[i] = Integer.parseInt(st2.nextToken());
        }

        Arrays.sort(map1);
        Arrays.sort(map2,(a,b) -> b - a);

        long result = 0;
        for(int i = 0 ; i < n; i++){
            result += (long)(map1[i] * map2[i]);
        }

        System.out.println(result);
    }
}