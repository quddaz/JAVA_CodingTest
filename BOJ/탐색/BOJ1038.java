import java.io.*;
import java.util.*;

public class Main {
    static List<Long> decreasingNumbers = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N <= 9) {
            System.out.println(N);
            return;
        }

        if (N > 1022) {
            System.out.println(-1);
            return;
        }

        generateDecreasingNumbers();
        Collections.sort(decreasingNumbers);
        System.out.println(decreasingNumbers.get(N));
    }

    public static void generateDecreasingNumbers() {
        for (int i = 0; i <= 9; i++) {
            generateNumbers(i, 1);
        }
    }

    public static void generateNumbers(long number, int length) {
        if (length > 10) {
            return;
        }

        decreasingNumbers.add(number);
        for (int i = 0; i < number % 10; i++) {
            generateNumbers(number * 10 + i, length + 1);
        }
    }
}
