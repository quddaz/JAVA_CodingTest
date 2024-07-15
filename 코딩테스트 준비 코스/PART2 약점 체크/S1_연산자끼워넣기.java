import java.io.*;
import java.util.*;

public class S1_14888 {
    static int N;
    static int[] arr;
    static int[] operation = new int[4];
    static int maxResult = Integer.MIN_VALUE; // 최댓값을 저장할 변수
    static int minResult = Integer.MAX_VALUE; // 최솟값을 저장할 변수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine()); 
        arr = new int[N]; 

        // 숫자 배열 초기화
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 연산자 개수 초기화
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operation[i] = Integer.parseInt(st.nextToken());
        }

        dfs(arr[0], 1);

        // 결과 출력
        System.out.println(maxResult);
        System.out.println(minResult);
    }

    // DFS
    public static void dfs(int num, int index) {
        // 모든 숫자와 연산을 사용한 경우
        if (index == N) {
            maxResult = Math.max(maxResult, num);
            minResult = Math.min(minResult, num);
            return;
        }

        // 모든 연산자에 대해 가능한 경우를 탐색
        for (int i = 0; i < 4; i++) {
            if (operation[i] > 0) {
                operation[i]--; // 연산자 사용 표시
                

                switch (i) {
                    case 0: // 덧셈
                        dfs(num + arr[index], index + 1);
                        break;
                    case 1: // 뺄셈
                        dfs(num - arr[index], index + 1);
                        break;
                    case 2: // 곱셈
                        dfs(num * arr[index], index + 1);
                        break;
                    case 3: // 나눗셈
                        //음수 처리 및 소수점 이하 버림
                        if (arr[index] != 0) {
                            dfs(num / arr[index], index + 1);
                        }
                        break;
                }
                
                operation[i]++; // 연산자 사용 표시 해제
            }
        }
    }
}