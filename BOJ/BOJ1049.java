import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int M = sc.nextInt();

        int[][] brands = new int[M][2];
        for (int i = 0; i < M; i++) {
            brands[i][0] = sc.nextInt();
            brands[i][1] = sc.nextInt();
        }

        int setMin = Integer.MAX_VALUE;
        int oneMin = Integer.MAX_VALUE;

        for (int i = 0; i < M; i++) {
            setMin = Math.min(setMin, brands[i][0]);
            oneMin = Math.min(oneMin, brands[i][1]);
        }

        int count;
        if (oneMin * 6 <= setMin) {
            count = oneMin * N;
        } else {
            int packages = N / 6;  // 패키지로 몇 번 구매하는지
            int remainder = N % 6;  // 낱개로 살 때의 나머지 개수

            count = packages * setMin + Math.min(remainder * oneMin, setMin);
        }

        System.out.println(count);
    }
}
