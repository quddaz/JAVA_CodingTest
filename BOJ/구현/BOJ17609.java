import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int t = 0; t < T; t++) {
            String str = br.readLine();
            int res = checkPalindrome(str);
            System.out.println(res);
        }
    }

    public static int checkPalindrome(String str) {
        int start = 0;
        int end = str.length() - 1;

        while (start < end) {
            if (str.charAt(start) == str.charAt(end)) {
                start++;
                end--;
            } else {
                if (isPalindrome(str, start + 1, end) || isPalindrome(str, start, end - 1)) {
                    return 1; // 유사회문
                } else {
                    return 2; // 일반 문자열
                }
            }
        }
        return 0; // 회문
    }

    public static boolean isPalindrome(String str, int start, int end) {
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}