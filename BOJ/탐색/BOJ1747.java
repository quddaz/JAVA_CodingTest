import java.io.*;
import java.util.*;

public class Main {
    static int MAX = 1003002;
    static boolean[] isPrime = new boolean[MAX + 1];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        setPrime();

        int num = Integer.parseInt(br.readLine());
        for (int i = num; i <= MAX; i++) {
            if (!isPrime[i] && isPalindrome(i)) {
                System.out.println(i);
                return;
            }
        }
    }

    public static void setPrime() {
        isPrime[0] = isPrime[1] = true; 

        for (int i = 2; i * i <= MAX; i++) {
            if (!isPrime[i]) { 
                for (int j = i * i; j <= MAX; j += i) {
                    isPrime[j] = true; 
                }
            }
        }
    }

    public static boolean isPalindrome(int num) {
        String cnt = String.valueOf(num);
        for (int i = 0; i < cnt.length() / 2; i++) {
            if (cnt.charAt(i) != cnt.charAt(cnt.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }
}
