import java.util.*;
import java.io.*;
 
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for (int testCase = 1; testCase <= 10; testCase++) {
            int n = Integer.parseInt(br.readLine());
            int map[][] = new int[n][n];
             
            for (int i = 0; i < n; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for (int j = 0; j < n; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }
             
            int count = 0;
            for(int j = 0; j < n; j++){
                boolean temp = false;
                for(int i = 0; i < n ; i++){
                    if(map[i][j] == 1){
                        temp = true;
                    }
                    else if(map[i][j] == 2 && temp){
                        count++;
                        temp = false;
                    }
                         
                }
            }
             
            System.out.printf("#%d %d%n", testCase, count);
        }
    }
}