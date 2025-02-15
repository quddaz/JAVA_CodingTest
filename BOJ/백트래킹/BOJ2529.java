import java.io.*;
import java.util.*;

public class Main {
    static List<String> list = new ArrayList<>();
    static int n;
    static String[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new String[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = st.nextToken();
        }
        boolean[] visited = new boolean[10];
        for (int i = 0; i <= 9; i++) {
            visited[i] = true;
            dfs(String.valueOf(i), 0, visited);
            visited[i] = false;
        }

        Collections.sort(list);
        System.out.println(list.get(list.size() - 1)); 
        System.out.println(list.get(0)); 
    }

    public static void dfs(String str, int depth, boolean[] visited) {
        if (depth == n) { 
            list.add(str);
            return;
        }

        for (int j = 0; j <= 9; j++) {
            if (!visited[j]) {
                if (arr[depth].equals("<") && (str.charAt(str.length() - 1) - '0' < j)) {
                    visited[j] = true;
                    dfs(str + j, depth + 1, visited);
                    visited[j] = false;
                } else if (arr[depth].equals(">") && (str.charAt(str.length() - 1) - '0' > j)) {
                    visited[j] = true;
                    dfs(str + j, depth + 1, visited);
                    visited[j] = false;
                }
            }
        }
    }
}
