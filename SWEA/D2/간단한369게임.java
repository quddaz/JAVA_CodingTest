import java.util.*;
import java.io.*;
 
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            int num = i;
            int count = 0;
 
            while (num > 0) {
                int temp = num % 10;
                if (temp == 3 || temp == 6 || temp == 9) {
                    count++;
                }
                num /= 10; 
            }
 
            if (count == 0) {
                System.out.print(i + " ");
            } else {
                for (int j = 0; j < count; j++) {
                    System.out.print("-");
                }
                System.out.print(" ");
            }
        }
    }
}