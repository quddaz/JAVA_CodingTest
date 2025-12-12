import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st1 = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st1.nextToken());
        int B = Integer.parseInt(st1.nextToken());

        StringTokenizer st2 = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st2.nextToken());
        int D = Integer.parseInt(st2.nextToken());

        int numerator = A * D + C * B;   // 합의 분자
        int denominator = B * D;         // 합의 분모

        int gcdValue = gcd(numerator, denominator);

        numerator /= gcdValue;
        denominator /= gcdValue;

        System.out.println(numerator + " " + denominator);
    }

    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = a % b;
            a = b;
            b = temp;
        }
        return a;
    }
}
