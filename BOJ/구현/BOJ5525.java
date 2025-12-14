import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        int answer = 0;
        int cnt = 0;

        for (int i = 1; i < M - 1; i++) {
            if (S.charAt(i - 1) == 'I' &&
                S.charAt(i) == 'O' &&
                S.charAt(i + 1) == 'I') {

                cnt++;

                if (cnt >= N) {
                    answer++;
                }

                i++; // IOI 중 I 다음으로 이동
            } else {
                cnt = 0;
            }
        }

        System.out.println(answer);
    }
}
