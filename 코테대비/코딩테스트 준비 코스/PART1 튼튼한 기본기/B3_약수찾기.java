import java.io.*;
import java.util.*;

public class B3_2501 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int count = 0;
        int point = 1;
        while (point <= n) {
            if (n % point == 0) {
                count++;
                if (count == k) {
                    System.out.println(point);
                    return;
                }
            }
            point++;
        }
        System.out.println(0);
    }
}