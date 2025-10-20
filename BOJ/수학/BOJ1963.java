import java.io.*;
import java.util.*;

public class Main {
    static boolean[] isPrime = new boolean[10000];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        sieve();

        while (T-- > 0) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int target = Integer.parseInt(st.nextToken());

            int result = bfs(start, target);
            if (result == -1) {
                System.out.println("Impossible");
            } else {
                System.out.println(result);
            }
        }
    }

    // 에라토스테네스의 체
    static void sieve() {
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        for (int i = 2; i * i < 10000; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j < 10000; j += i) {
                    isPrime[j] = false;
                }
            }
        }
    }

    static int bfs(int start, int target) {
        boolean[] visited = new boolean[10000];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{start, 0});
        visited[start] = true;

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int num = cur[0];
            int cnt = cur[1];

            if (num == target) return cnt;

            char[] arr = String.valueOf(num).toCharArray();
            for (int i = 0; i < 4; i++) {
                char original = arr[i];
                for (char c = '0'; c <= '9'; c++) {
                    if (c == original) continue;
                    arr[i] = c;
                    int next = Integer.parseInt(new String(arr));
                    if (next >= 1000 && isPrime[next] && !visited[next]) {
                        visited[next] = true;
                        q.offer(new int[]{next, cnt + 1});
                    }
                }
                arr[i] = original; // 원상복구
            }
        }
        return -1; // 불가능
    }
}
