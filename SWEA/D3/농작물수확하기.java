import java.util.*;
import java.io.*;
 
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int testCaseCount = Integer.parseInt(reader.readLine());
         
        for (int testCase = 1; testCase <= testCaseCount; testCase++) {
            int sum = 0;
            int size = Integer.parseInt(reader.readLine());
            int center = size / 2;
             
            for (int row = 0; row < size; row++) {
                StringTokenizer tokenizer = new StringTokenizer(reader.readLine());
                int offset = Math.abs(center - row);
                String rowData = tokenizer.nextToken();
                 
                for (int col = offset; col < size - offset; col++) {
                    sum += rowData.charAt(col) - '0';
                }
            }
             
            System.out.println("#" + testCase + " " + sum);
        }
    }