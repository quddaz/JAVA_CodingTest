import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<Long, Integer> countMap = new HashMap<>(); 
        for (int i = 0; i < n; i++) {
            long card = Long.parseLong(br.readLine()); 
            countMap.put(card, countMap.getOrDefault(card, 0) + 1);
        }

        long maxCard = 0; 
        int maxCount = 0; 

        for (Map.Entry<Long, Integer> entry : countMap.entrySet()) {
            long card = entry.getKey();
            int count = entry.getValue();

            if (count > maxCount || (count == maxCount && card < maxCard)) {
                maxCount = count;
                maxCard = card;
            }
        }

        System.out.println(maxCard);
    }
}
