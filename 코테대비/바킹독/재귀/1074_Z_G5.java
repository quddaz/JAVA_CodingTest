import java.io.*;
import java.util.*;

public class Main {
    static int n, r, c;
    static int num = 0;
    static int result = 0;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        int length = 1 << n;

        solve(0,0,length);
        System.out.println(result);
    }

public static void solve(int x, int y, int size) {
    if (x == r && y == c && size == 1) {
        result = num;
        return;
    }
    if (size == 1) {
        num++;
        return;
    }

    int half = size / 2;
    int area = half * half;

    if (r < x + half && c < y + half) {
        solve(x, y, half);
    }
    else if (r < x + half && c >= y + half) {
        num += area;
        solve(x, y + half, half);
    }
    else if (r >= x + half && c < y + half) {
        num += area * 2;
        solve(x + half, y, half);
    }
    else {
        num += area * 3;
        solve(x + half, y + half, half);
    }
}

}