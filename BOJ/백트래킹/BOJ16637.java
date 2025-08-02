import java.io.*;
import java.util.*;

public class Main {
    static int N, max = Integer.MIN_VALUE;
    static ArrayList<Integer> nums = new ArrayList<>();
    static ArrayList<Character> ops = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        String str = br.readLine();

        for (int i = 0; i < N; i++) {
            char c = str.charAt(i);
            if (i % 2 == 0) nums.add(c - '0');
            else ops.add(c);
        }

        dfs(0, nums.get(0));
        System.out.println(max);
    }

    static void dfs(int idx, int sum) {
        if (idx >= ops.size()) {
            max = Math.max(max, sum);
            return;
        }

        int temp1 = calc(sum, nums.get(idx + 1), ops.get(idx));
        dfs(idx + 1, temp1);

        if (idx + 1 < ops.size()) {
            int bracket = calc(nums.get(idx + 1), nums.get(idx + 2), ops.get(idx + 1));
            int temp2 = calc(sum, bracket, ops.get(idx));
            dfs(idx + 2, temp2);
        }
    }

    static int calc(int a, int b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            default: return a * b;
        }
    }
}
