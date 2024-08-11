import java.io.*;
import java.util.*;

public class Main {
    static int N, M, K, X;
    static List<Integer>[] ar;
    static boolean[] visited;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());

        ar = new ArrayList[N + 1];
        visited = new boolean[N + 1];
        result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            ar[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            ar[A].add(B);
        }

        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{X, 0});
        visited[X] = true;

        while (!q.isEmpty()) {
            int[] num = q.poll();
            int city = num[0];
            int count = num[1];

            if (count == K) {
                result.add(city);
            } else if (count < K) {
                for (int move : ar[city]) {
                    if (!visited[move]) {
                        visited[move] = true;
                        q.add(new int[]{move, count + 1});
                    }
                }
            }
        }

        if (result.isEmpty()) {
            System.out.println(-1);
        } else {
            Collections.sort(result);  // 결과를 오름차순으로 정렬
            for (int city : result) {
                System.out.println(city);
            }
        }
    }
}
