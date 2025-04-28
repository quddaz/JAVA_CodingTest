import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int n = Integer.parseInt(br.readLine());
        int[] price = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        
        for (int i = 0; i < n; i++) {
            price[i] = Integer.parseInt(st.nextToken());
        }
        
        int m = Integer.parseInt(br.readLine());

        int minCost = Integer.MAX_VALUE;
        int minIdx = -1;
        for (int i = 0; i < n; i++) {
            if (price[i] < minCost) {
                minCost = price[i];
                minIdx = i;
            }
        }

        int firstMinCost = Integer.MAX_VALUE;
        int firstMinIdx = -1;
        for (int i = 1; i < n; i++) {
            if (price[i] < firstMinCost) {
                firstMinCost = price[i];
                firstMinIdx = i;
            }
        }


        if (firstMinIdx == -1 || m < firstMinCost) {
            System.out.println(0);
            return;
        }

        m -= firstMinCost;
        int length = 1 + (m / minCost); 
        m -= (length - 1) * minCost; 
        int[] ans = new int[length];
        ans[0] = firstMinIdx; 

        Arrays.fill(ans, 1, length, minIdx);
        
        for (int i = 0; i < length; i++) {
            for (int j = n - 1; j >= 0; j--) {
                int need = price[j] - price[ans[i]];
                if (need <= m) {
                    m -= need;
                    ans[i] = j;
                    break;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int num : ans) {
            sb.append(num);
        }
        System.out.println(sb);
    }
}
