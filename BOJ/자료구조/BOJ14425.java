import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 첫 줄 입력
        String[] nm = br.readLine().split(" ");
        int N = Integer.parseInt(nm[0]);
        int M = Integer.parseInt(nm[1]);

        // 집합 S에 포함된 문자열들을 저장할 HashSet
        HashSet<String> set = new HashSet<>();

        // N개의 문자열 입력 및 HashSet에 저장
        for (int i = 0; i < N; i++) {
            set.add(br.readLine());
        }

        int count = 0;

        // M개의 문자열을 입력받고 집합에 포함되는지 확인
        for (int i = 0; i < M; i++) {
            if (set.contains(br.readLine())) {
                count++;
            }
        }

        // 결과 출력
        System.out.println(count);
    }
}
