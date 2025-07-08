import java.util.*;
import java.io.*;
 
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        for (int testCase = 1; testCase <= 10; testCase++) {
            reader.readLine(); // 테스트 케이스 숫자 읽고 버리기
            StringTokenizer st = new StringTokenizer(reader.readLine());
            Queue<Integer> queue = new LinkedList<>();
             
            // 큐에 초기 8개 숫자 추가
            for (int i = 0; i < 8; i++) {
                queue.add(Integer.parseInt(st.nextToken()));
            }
             
            int decrement = 1;
            while (true) {
                int num = queue.poll() - decrement;
                if (num <= 0) {
                    queue.add(0);
                    break;
                }
                queue.add(num);
                decrement = (decrement % 5) + 1; // 1~5까지 반복
            }
             
            // 결과 출력
            System.out.print("#" + testCase);
            for (int i = 0; i < 8; i++) {
                System.out.print(" " + queue.poll());
            }
            System.out.println(); 
        }
    }
}