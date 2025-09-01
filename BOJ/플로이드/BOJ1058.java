import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        boolean[][] friends = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            for (int j = 0; j < N; j++) {
                if (line.charAt(j) == 'Y') {
                    friends[i][j] = true;
                }
            }
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            boolean[] visited = new boolean[N];
            for (int j = 0; j < N; j++) {
                if (i == j) continue;
                if (friends[i][j]) {
                    visited[j] = true; 
                } else {
                    for (int k = 0; k < N; k++) {
                        if (friends[i][k] && friends[k][j]) {
                            visited[j] = true;
                            break;
                        }
                    }
                }
            }
            int count = 0;
            for (boolean v : visited) if (v) count++;
            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
