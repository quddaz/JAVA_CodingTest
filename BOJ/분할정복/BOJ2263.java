import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[] inorder, postorder;
    static Map<Integer, Integer> idxMap;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        inorder = new int[n];
        postorder = new int[n];
        idxMap = new HashMap<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            inorder[i] = Integer.parseInt(st.nextToken());
            idxMap.put(inorder[i], i);
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            postorder[i] = Integer.parseInt(st.nextToken());
        }

        preorder(0, n - 1, 0, n - 1);

        System.out.println(sb);
    }

    static void preorder(int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) return;

        int root = postorder[postEnd];
        sb.append(root).append(" ");

        int rootIndex = idxMap.get(root);
        int leftSize = rootIndex - inStart;

        preorder(inStart, rootIndex - 1, postStart, postStart + leftSize - 1);
        preorder(rootIndex + 1, inEnd, postStart + leftSize, postEnd - 1);
    }
}