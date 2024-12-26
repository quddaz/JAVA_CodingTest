import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int map[] = new int[n];

        for(int i = 0; i < n; i++){
            map[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for(int i = n-1; i > 0; i--){
            if(map[i] <= map[i-1]){
                result += map[i-1] - (map[i] - 1);
                map[i-1] = map[i] - 1; 
            }
        }

        System.out.println(result);
    }
}
