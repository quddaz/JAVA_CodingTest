import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        String[] words = new String[N];
        
        for (int i = 0; i < N; i++) {
            words[i] = br.readLine();
        }
        
        System.out.println(getMaxSum(words));
    }

    private static int getMaxSum(String[] words) {
        Map<Character, Integer> charWeight = new HashMap<>();
        
        for (String word : words) {
            int length = word.length();
            for (int i = 0; i < length; i++) {
                char c = word.charAt(i);
                int weight = (int) Math.pow(10, length - i - 1);
                charWeight.put(c, charWeight.getOrDefault(c, 0) + weight);
            }
        }
        
        List<Integer> values = new ArrayList<>(charWeight.values());
        values.sort(Collections.reverseOrder());
        
        int num = 9, maxSum = 0;
        for (int value : values) {
            maxSum += value * num;
            num--;
        }
        
        return maxSum;
    }
}