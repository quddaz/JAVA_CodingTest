import java.io.*;
import java.util.*;

public class Main {
    static class Node {
        Map<String, Node> children = new TreeMap<>();
    }

    static Node root = new Node();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int k = Integer.parseInt(st.nextToken());

            Node current = root;
            for (int j = 0; j < k; j++) {
                String food = st.nextToken();
                current.children.putIfAbsent(food, new Node());
                current = current.children.get(food);
            }
        }

        dfs(root, 0);
    }

    static void dfs(Node node, int depth) {
        for (String key : node.children.keySet()) {
            for (int i = 0; i < depth; i++) {
                System.out.print("--");
            }
            System.out.println(key);
            dfs(node.children.get(key), depth + 1);
        }
    }
}
