import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

    static long countFactor(long n, long k) {
        long count = 0;
        while (n > 0) {
            n /= k;
            count += n;
        }
        return count;
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        long two = countFactor(n, 2)
                 - countFactor(m, 2)
                 - countFactor(n - m, 2);

        long five = countFactor(n, 5)
                  - countFactor(m, 5)
                  - countFactor(n - m, 5);

        System.out.println(Math.min(two, five));
    }
}
