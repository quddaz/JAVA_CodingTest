import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static long[] factorial;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        factorial = new long[N + 1];
        visited = new boolean[N + 1];
        factorial[0] = 1;

        for (int i = 1; i <= N; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        st = new StringTokenizer(br.readLine());
        int type = Integer.parseInt(st.nextToken());

        if (type == 1) {
            long k = Long.parseLong(st.nextToken());
            getPermutation(k);
        } else {
            int[] perm = new int[N];
            for (int i = 0; i < N; i++) {
                perm[i] = Integer.parseInt(st.nextToken());
            }
            getOrder(perm);
        }
    }

    // 1번: k번째 순열 구하기
    static void getPermutation(long k) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 1; j <= N; j++) {
                if (visited[j]) continue;
                if (factorial[N - i - 1] < k) {
                    k -= factorial[N - i - 1];
                } else {
                    result.add(j);
                    visited[j] = true;
                    break;
                }
            }
        }
        for (int num : result) {
            System.out.print(num + " ");
        }
    }

    // 2번: 순열의 사전 순서 구하기
    static void getOrder(int[] perm) {
        long order = 1;
        for (int i = 0; i < N; i++) {
            for (int j = 1; j < perm[i]; j++) {
                if (!visited[j]) {
                    order += factorial[N - i - 1];
                }
            }
            visited[perm[i]] = true;
        }
        System.out.println(order);
    }
}
