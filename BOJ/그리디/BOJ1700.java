import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] schedule = new int[k];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < k; i++) {
            schedule[i] = Integer.parseInt(st.nextToken());
        }

        List<Integer> li = new ArrayList<>();
        int result = 0;

        for(int i = 0; i < k; i++){
            int num = schedule[i];

            if(li.contains(num))
                continue;
            if(li.size() < n){
                li.add(num);
                continue;
            }

            int maxIndex = -1;
            int toUnplug = -1;

            for(int device : li){
                int nextUse = Integer.MAX_VALUE;
                for (int j = i + 1; j < k; j++) {
                    if (schedule[j] == device) {
                        nextUse = j;
                        break;
                    }
                }
                if (nextUse > maxIndex) {
                    maxIndex = nextUse;
                    toUnplug = device;
                }
            }
            li.remove((Integer) toUnplug);
            li.add(num);
            result++;
        }
        System.out.println(result);
    }
}
