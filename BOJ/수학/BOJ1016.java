import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long min = Long.parseLong(st.nextToken());
        long max = Long.parseLong(st.nextToken());
        int size = (int)(max - min + 1);
        boolean[] isSquareFree = new boolean[size];
        Arrays.fill(isSquareFree, true);

        for (long i = 2; i * i <= max; i++) {
            long pow = i * i;
            long start = ((min + pow - 1) / pow) * pow;

            for (long j = start; j <= max; j += pow) {
                isSquareFree[(int)(j - min)] = false;
            }
        }

        int count = 0;
        for (int i = 0; i < size; i++) {
            if (isSquareFree[i]) count++;
        }

        System.out.println(count);
    }
}
