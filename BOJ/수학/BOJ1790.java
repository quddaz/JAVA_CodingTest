import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        long N = Long.parseLong(input[0]);
        long k = Long.parseLong(input[1]);

        long totalLength = 0;
        long count = 9;
        long digit = 1;
        long start = 1;

        while (start <= N) {
            long end = Math.min(N, start * 10 - 1);
            long numbers = end - start + 1;
            totalLength += numbers * digit;
            start *= 10;
            digit++;
        }

        if (totalLength < k) {
            System.out.println(-1);
            return;
        }

        long length = 0;
        count = 9;
        digit = 1;
        start = 1;

        while (true) {
            long end = Math.min(N, start * 10 - 1);
            long numbers = end - start + 1;
            long rangeLen = numbers * digit;

            if (k <= length + rangeLen) {
                long offset = k - length - 1;
                long number = start + offset / digit;
                int index = (int) (offset % digit);
                System.out.println(Long.toString(number).charAt(index));
                return;
            }

            length += rangeLen;
            start *= 10;
            digit++;
        }
    }
}
