import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 기타 개수 (≤10)
        int M = Integer.parseInt(st.nextToken()); // 곡 개수  (≤50)

        long[] mask = new long[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();               // 기타 이름은 사용하지 않음
            String s = st.nextToken();    // Y/N 문자열
            long m = 0L;
            for (int j = 0; j < M; j++) {
                if (s.charAt(j) == 'Y') m |= (1L << j);
            }
            mask[i] = m;
        }

        int bestSongs = 0;       
        int bestGuitars = Integer.MAX_VALUE; 

        int total = 1 << N;
        for (int subset = 1; subset < total; subset++) {
            long combined = 0L;
            for (int i = 0; i < N; i++) {
                if ((subset & (1 << i)) != 0) combined |= mask[i];
            }
            int songs = Long.bitCount(combined);
            int guitars = Integer.bitCount(subset);

            if (songs > bestSongs || (songs == bestSongs && guitars < bestGuitars)) {
                bestSongs = songs;
                bestGuitars = guitars;
            }
        }

        if (bestSongs == 0) System.out.println(-1);
        else System.out.println(bestGuitars);
    }
}
