import java.io.*;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 입력 받기
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]); // 큐의 크기
        int M = Integer.parseInt(input[1]); // 뽑아내려는 수의 개수
        
        LinkedList<Integer> deque = new LinkedList<>();
        for (int i = 1; i <= N; i++) {
            deque.add(i);  // 큐 초기화 (1부터 N까지)
        }
        
        String[] positions = br.readLine().split(" ");
        int[] targets = new int[M];
        for (int i = 0; i < M; i++) {
            targets[i] = Integer.parseInt(positions[i]);
        }
        
        int totalOperations = 0;  // 2번, 3번 연산의 총 횟수
        
        for (int target : targets) {
            int targetIdx = deque.indexOf(target);  // 현재 큐에서 타겟의 인덱스
            
            int leftOps = targetIdx;  // 왼쪽으로 이동할 때의 연산 수
            int rightOps = deque.size() - targetIdx;  // 오른쪽으로 이동할 때의 연산 수
            
            // 더 적은 연산을 선택
            if (leftOps <= rightOps) {
                // 왼쪽으로 이동
                totalOperations += leftOps;
                for (int i = 0; i < leftOps; i++) {
                    deque.addLast(deque.removeFirst());
                }
            } else {
                // 오른쪽으로 이동
                totalOperations += rightOps;
                for (int i = 0; i < rightOps; i++) {
                    deque.addFirst(deque.removeLast());
                }
            }
            
            // 첫 번째 원소를 뽑아낸다.
            deque.removeFirst();
        }
        
        System.out.println(totalOperations);
    }
}
