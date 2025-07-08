import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 멀티탭 구멍 개수
        int K = Integer.parseInt(st.nextToken()); // 전기용품 사용 횟수

        int[] schedule = new int[K]; 
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            schedule[i] = Integer.parseInt(st.nextToken());
        }

        Set<Integer> multitap = new HashSet<>(); 
        int count = 0;

        for (int i = 0; i < K; i++) {
            int current = schedule[i];

            if (multitap.contains(current)) continue;


            if (multitap.size() < N) {
                multitap.add(current);
                continue;
            }

            int farthestIdx = -1, unplugTarget = -1;

            for (int plug : multitap) {
                int nextUse = Integer.MAX_VALUE;
                for (int j = i + 1; j < K; j++) {
                    if (schedule[j] == plug) {
                        nextUse = j;
                        break;
                    }
                }
                if (nextUse > farthestIdx) {
                    farthestIdx = nextUse;
                    unplugTarget = plug;
                }
            }

            multitap.remove(unplugTarget);
            multitap.add(current);
            count++;
        }

        System.out.println(count);
    }
}
