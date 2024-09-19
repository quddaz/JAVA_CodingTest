import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(reader.readLine().trim());

        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            String command = reader.readLine().trim();
            String[] parts = command.split(" ");
            String operation = parts[0];

            switch (operation) {
                case "push":
                    int value = Integer.parseInt(parts[1]);
                    queue.add(value);
                    break;

                case "pop":
                    if (queue.isEmpty()) {
                        System.out.println("-1");
                    } else {
                        System.out.println(queue.poll());
                    }
                    break;

                case "size":
                    System.out.println(queue.size());
                    break;

                case "empty":
                    System.out.println(queue.isEmpty() ? "1" : "0");
                    break;

                case "front":
                    System.out.println(queue.isEmpty() ? "-1" : queue.peek());
                    break;

                case "back":
                    System.out.println(queue.isEmpty() ? "-1" : ((LinkedList<Integer>) queue).peekLast());
                    break;
            }
        }
    }
}
