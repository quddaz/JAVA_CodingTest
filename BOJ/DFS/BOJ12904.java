import java.util.Scanner;

public class Main {
    static String S, T;
    static boolean isPossible = false;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        S = sc.next();
        T = sc.next();

        dfs(T);
        System.out.println(isPossible ? 1 : 0);
    }

    static void dfs(String current) {
        if (current.length() < S.length()) return;

        if (current.equals(S)) {
            isPossible = true;
            return;
        }

        if (current.charAt(current.length() - 1) == 'A') {
            dfs(current.substring(0, current.length() - 1));
        }

        if (current.charAt(current.length() - 1) == 'B') {
            String reversed = new StringBuilder(current.substring(0, current.length() - 1)).reverse().toString();
            dfs(reversed);
        }
    }
}
