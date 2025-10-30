import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long W = Long.parseLong(st.nextToken());
        long H = Long.parseLong(st.nextToken());
        long f = Long.parseLong(st.nextToken());
        long c = Long.parseLong(st.nextToken());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());

        long total = W * H;
        long fold = Math.min(f, W - f);
        long paintedX = 0;

        long leftOverlap = Math.max(0, Math.min(x2, fold) - Math.min(x1, fold));
        long right = Math.max(0, x2 - Math.max(x1, fold));
        paintedX = leftOverlap * 2 + right;

        long paintedY = (y2 - y1) * (c + 1);
        long painted = paintedX * paintedY;

        long result = total - painted;
        System.out.println(result);
    }
}
