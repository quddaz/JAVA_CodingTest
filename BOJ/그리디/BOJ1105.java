import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());
        
        int minCount = Integer.MAX_VALUE;
        for (int i = L; i <= R; i++) {
            int count = countEights(i);
            minCount = Math.min(minCount, count);
            if (minCount == 0) break; 
        }
        
        System.out.println(minCount);
    }
    
    private static int countEights(int num) {
        int count = 0;
        while (num > 0) {
            if (num % 10 == 8) {
                count++;
            }
            num /= 10;
        }
        return count;
    }
}