import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class G5_2023 {

    // 소수 판별 함수
    public static boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    // DFS를 사용한 신기한 소수 찾기
    public static void dfs(int n, int number) {
        // 현재 숫자가 N자리인 경우 출력
        if (Integer.toString(number).length() == n) {
            System.out.println(number);
        } else {
            // 다음 자리에 1~9까지의 숫자를 붙여서 DFS 탐색
            for (int i = 1; i <= 9; i++) {
                int nextNumber = number * 10 + i;
                if (isPrime(nextNumber)) {
                    dfs(n, nextNumber);
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        // BufferedReader와 StringTokenizer를 사용해 입력 처리
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());

        // 1자리 소수에서부터 시작하는 DFS
        dfs(n, 2);
        dfs(n, 3);
        dfs(n, 5);
        dfs(n, 7);
    }
}