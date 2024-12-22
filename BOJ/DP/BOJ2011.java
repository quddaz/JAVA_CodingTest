import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        int length = str.length();
        int[] dp = new int[length + 1];

        dp[0] = 1;
        dp[1] = (str.charAt(0) != '0') ? 1 : 0;

        for (int i = 2; i <= length; i++) {
            if (str.charAt(i - 1) != '0') {
                dp[i] += dp[i - 1];
                dp[i] %= 1000000;
            }

            int num = Integer.parseInt(str.substring(i - 2, i));
            if (num >= 10 && num <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= 1000000;
            }
        }

        System.out.println(dp[length]);
    }
}
