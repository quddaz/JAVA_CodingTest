import java.io.*;
import java.util.*;

public class Main {
    static int map[][];
    static int n;
    static int a, b, c;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        
        solve(0, n, 0, n);
        
        System.out.println(c);
        System.out.println(a);
        System.out.println(b);
    }

    public static void solve(int startx, int endx, int starty, int endy) {
        if (checkMap(startx, endx, starty, endy)) {
            if (map[startx][starty] == 0)
                a++;
            else if (map[startx][starty] == 1)
                b++;
            else
                c++;
            return;
        }
        
        int new_n = (endx - startx) / 3;

        solve(startx, startx + new_n, starty, starty + new_n);
        solve(startx, startx + new_n, starty + new_n, starty + 2 * new_n);
        solve(startx, startx + new_n, starty + 2 * new_n, endy);
        
        solve(startx + new_n, startx + 2 * new_n, starty, starty + new_n);
        solve(startx + new_n, startx + 2 * new_n, starty + new_n, starty + 2 * new_n);
        solve(startx + new_n, startx + 2 * new_n, starty + 2 * new_n, endy);
        
        solve(startx + 2 * new_n, endx, starty, starty + new_n);
        solve(startx + 2 * new_n, endx, starty + new_n, starty + 2 * new_n);
        solve(startx + 2 * new_n, endx, starty + 2 * new_n, endy);
    }

    public static boolean checkMap(int startx, int endx, int starty, int endy) {
        int temp = map[startx][starty];

        for (int i = startx; i < endx; i++) {
            for (int j = starty; j < endy; j++) {
                if (map[i][j] != temp)
                    return false;
            }
        }

        return true;
    }
}
