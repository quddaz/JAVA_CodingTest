import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] size = br.readLine().split(" ");
        int n = Integer.parseInt(size[0]);
        int m = Integer.parseInt(size[1]);

        char[][] floor = new char[n][m];

        for (int i = 0; i < n; i++) {
            String line = br.readLine();
            floor[i] = line.toCharArray();
        }

        int result = 0;

        for (int i = 0; i < n; i++) {
            int check = 0;
            for (int j = 0; j < m; j++) {
                if (floor[i][j] == '|') {
                    check = 0;
                } else if (check == 0 && floor[i][j] == '-') {
                    check = 1;
                    result++;
                }
            }
        }

        for (int i = 0; i < m; i++) {
            int check = 0;
            for (int j = 0; j < n; j++) {
                if (floor[j][i] == '-') {
                    check = 0;
                } else if (check == 0 && floor[j][i] == '|') {
                    check = 1;
                    result++;
                }
            }
        }

        System.out.println(result);
    }
}