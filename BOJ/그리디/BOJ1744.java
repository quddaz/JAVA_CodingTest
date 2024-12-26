import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        List<Integer> posi = new ArrayList<>();
        List<Integer> nega = new ArrayList<>();
        long sum = 0;
        int zero_count = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (num > 1) posi.add(num);
            else if (num < 0) nega.add(num);
            else if (num == 1) sum += 1;
            else if (num == 0) zero_count++;
        }

        Collections.sort(posi, Collections.reverseOrder());
        Collections.sort(nega);

        if(posi.size() > 1)
            for(int i = 0; i < posi.size()-1; i+=2)
                sum += posi.get(i) * posi.get(i+1);
            
        
        if(posi.size() % 2 == 1)sum += posi.get(posi.size() - 1);
        
        if(nega.size() > 1)
            for(int i = 0; i < nega.size()-1; i+=2)
                sum += nega.get(i) * nega.get(i+1);
        
        if(nega.size() % 2 == 1 && zero_count == 0)
            sum += nega.get(nega.size() - 1);

        System.out.println(sum);
    }
}
