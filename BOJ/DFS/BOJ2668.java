import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static int[] arr;
    static boolean[] visited;
    static boolean[] finished;
    static List<Integer> result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        arr = new int[N + 1];
        visited = new boolean[N + 1];
        finished = new boolean[N + 1];
        result = new ArrayList<>();

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        for (int i = 1; i <= N; i++) {
            visited = new boolean[N + 1]; 
            dfs(i, i);
        }

        Collections.sort(result);

        System.out.println(result.size());
        for (int num : result) {
            System.out.println(num);
        }
    }

    static void dfs(int start, int target) {
        if (!visited[start]) {
            visited[start] = true;
            dfs(arr[start], target);
        } else {
            if (start == target) {
                result.add(target);
            }
        }
    }
}
