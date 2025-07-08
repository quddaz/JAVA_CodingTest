import java.util.*;
import java.io.*;
 
class Solution {
    static int maxPrize;
    static int maxCount;
 
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
 
        for (int i = 1; i <= T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            char[] digits = st.nextToken().toCharArray();
            maxCount = Math.min(Integer.parseInt(st.nextToken()), digits.length);
            maxPrize = 0;
            dfs(0, digits);
 
 
            System.out.println("#" + i + " " + maxPrize);
        }
    }
 
    public static void dfs(int count, char[] digits) {
        if (count == maxCount) {
            calculatePrize(digits);
            return;
        }
 
        for (int i = 0; i < digits.length; i++) {
            for (int j = i + 1; j < digits.length; j++) {
                // Swap
                swap(digits, i, j);
                // Recursive DFS
                dfs(count + 1, digits);
                // Backtrack
                swap(digits, i, j);
            }
        }
    }
 
    private static void swap(char[] digits, int i, int j) {
        char temp = digits[i];
        digits[i] = digits[j];
        digits[j] = temp;
    }
 
    private static void calculatePrize(char[] digits) {
        int prize = 0;
        for (char digit : digits) {
            prize = prize * 10 + (digit - '0');
        }
        maxPrize = Math.max(maxPrize, prize);
    }
}