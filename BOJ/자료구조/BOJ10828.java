import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> stack = new Stack<>();
        
        int N = sc.nextInt();  // 명령의 수
        sc.nextLine();  // 개행 문자 처리
        
        for (int i = 0; i < N; i++) {
            String command = sc.nextLine();
            
            if (command.startsWith("push")) {
                // push 명령일 경우
                int x = Integer.parseInt(command.split(" ")[1]);
                stack.push(x);
            } else if (command.equals("pop")) {
                // pop 명령일 경우
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.pop());
                }
            } else if (command.equals("size")) {
                // size 명령일 경우
                System.out.println(stack.size());
            } else if (command.equals("empty")) {
                // empty 명령일 경우
                if (stack.isEmpty()) {
                    System.out.println(1);
                } else {
                    System.out.println(0);
                }
            } else if (command.equals("top")) {
                // top 명령일 경우
                if (stack.isEmpty()) {
                    System.out.println(-1);
                } else {
                    System.out.println(stack.peek());
                }
            }
        }
        
        sc.close();
    }
}
