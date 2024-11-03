import java.util.*;
import java.io.*;
 
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        for (int testCase = 1; testCase <= 10; testCase++) {
            br.readLine(); 
            String str = br.readLine(); 
            String target = br.readLine(); 
             
            int result = (target.length() - target.replace(str, "").length()) / str.length();
             
            System.out.printf("#%d %d%n", testCase, result);
        }
    }
}