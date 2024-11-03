import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
         
        for (int t = 1; t <= T; t++) {
            String memory = br.readLine();
            int changes = 0;
            char previousBit = '0';
 
            // 현재 비트가 이전 비트와 다를 때마다 변경 횟수를 추가합니다.
            for (int i = 0; i < memory.length(); i++) {
                if (memory.charAt(i) != previousBit) {
                    changes++;
                    previousBit = memory.charAt(i);
                }
            }
 
            System.out.printf("#%d %d%n", t, changes);
        }
    }
}