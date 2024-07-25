import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class G4_14226 {
    static int S;
    static boolean visited[][];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        S = Integer.parseInt(br.readLine());
        visited = new boolean[1001][1001];
        
        int result = bfs();
        System.out.println(result);
    }

    public static int bfs() {
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0, 0}); 

        visited[1][0] = true; 

        while (!q.isEmpty()) {
            int[] state = q.poll();
            int screen = state[0];
            int clipboard = state[1];
            int count = state[2];

            if (screen == S) {
                return count;
            }

            if (clipboard != screen && !visited[screen][screen]) {
                visited[screen][screen] = true;
                q.add(new int[]{screen, screen, count + 1});
            }

            if (clipboard != 0 && screen + clipboard <= 1000 && !visited[screen + clipboard][clipboard]) {
                visited[screen + clipboard][clipboard] = true;
                q.add(new int[]{screen + clipboard, clipboard, count + 1});
            }

            if (screen - 1 >= 0 && !visited[screen - 1][clipboard]) {
                visited[screen - 1][clipboard] = true;
                q.add(new int[]{screen - 1, clipboard, count + 1});
            }
        }

        return -1; 
    }
}
