import java.util.Arrays;
import java.util.Scanner;

public class G1041 { // 주사위

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long N = sc.nextLong();
        long[] diceValues = new long[6];

        long sum = 0;
        for (int i = 0; i < 6; i++) {
            diceValues[i] = sc.nextLong();
            sum += diceValues[i];
        }

        if (N == 1) {
            Arrays.sort(diceValues);
            System.out.println(sum - diceValues[5]);
            return;
        }

        long[] sideSums = new long[3];
        sideSums[0] = Math.min(diceValues[0], diceValues[5]); // af
        sideSums[1] = Math.min(diceValues[1], diceValues[4]); // be
        sideSums[2] = Math.min(diceValues[2], diceValues[3]); // cd

        long minSideSum = Long.MAX_VALUE;
        for (int i = 0; i < 6; i++) {
            if (minSideSum > diceValues[i])
                minSideSum = diceValues[i];
        }

        long minTwoSideSum = Math.min(sideSums[0] + sideSums[1], Math.min(sideSums[1] + sideSums[2], sideSums[0] + sideSums[2]));

        long minThreeSideSum = 0;
        for (int i = 0; i < 3; i++) {
            minThreeSideSum += sideSums[i];
        }

        long pattern1 = (N - 2) * (N - 2) * 5 + (N - 2) * 4;
        long pattern2 = (N - 2) * 8 + 4;
        long total = minSideSum * pattern1 + minTwoSideSum * pattern2 + minThreeSideSum * 4;
        System.out.println(total);
    }
}