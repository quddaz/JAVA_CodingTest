import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x3 = Long.parseLong(st.nextToken());
        long y3 = Long.parseLong(st.nextToken());
        long x4 = Long.parseLong(st.nextToken());
        long y4 = Long.parseLong(st.nextToken());

        int res1 = ccw(x1, y1, x2, y2, x3, y3);
        int res2 = ccw(x1, y1, x2, y2, x4, y4);
        int res3 = ccw(x3, y3, x4, y4, x1, y1);
        int res4 = ccw(x3, y3, x4, y4, x2, y2);

        if (res1 * res2 < 0 && res3 * res4 < 0) {
            System.out.println(1);
        } else {
            System.out.println(0);
        }
    }

    public static int ccw(long x1, long y1, long x2, long y2, long x3, long y3) {
        long result = (x1 * y2 + x2 * y3 + x3 * y1) - (y1 * x2 + y2 * x3 + y3 * x1);
        if (result > 0) return 1;
        else if (result < 0) return -1;
        else return 0;
    }
}