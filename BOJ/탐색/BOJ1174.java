import java.io.;
import java.util.;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        ListLong decreasingNumbers = new ArrayList();
        QueueLong queue = new LinkedList();

        for (long i = 0; i = 9; i++) {
            queue.add(i);
            decreasingNumbers.add(i);
        }

        while (!queue.isEmpty()) {
            long num = queue.poll();
            long lastDigit = num % 10;

            for (long i = 0; i  lastDigit; i++) {
                long newNum = num  10 + i;
                queue.add(newNum);
                decreasingNumbers.add(newNum);
            }
        }

        if (N  decreasingNumbers.size()) {
            System.out.println(-1n);
        } else {
            System.out.println(decreasingNumbers.get(N - 1) + n);
        }
    }
}
