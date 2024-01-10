import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a)); // 내림차순으로 정렬
        int count = 0;
        int N = scanner.nextInt();

        int My = scanner.nextInt();
        for (int i = 1; i < N; i++) {
            pq.add(scanner.nextInt());
        }

        while (!pq.isEmpty() && My <= pq.peek()) {
            int temp = pq.poll();
            temp--;
            My++;
            count++;
            pq.add(temp);
        }

        System.out.println(count);
    }
}