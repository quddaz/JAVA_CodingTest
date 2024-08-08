import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        // 입력을 효율적으로 처리하기 위해 BufferedReader 사용
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 출력을 효율적으로 처리하기 위해 BufferedWriter 사용
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        // 첫 줄 입력 받아서 N과 M에 저장
        String[] input = br.readLine().split(" ");
        int N = Integer.parseInt(input[0]);
        int M = Integer.parseInt(input[1]);
        
        // 포켓몬 이름을 숫자와 매핑하기 위한 두 개의 HashMap
        HashMap<String, Integer> nameToNumber = new HashMap<>();
        String[] numberToName = new String[N + 1];  // 1-based index 사용
        
        // N개의 포켓몬 이름을 읽어들임
        for (int i = 1; i <= N; i++) {
            String name = br.readLine();
            nameToNumber.put(name, i);
            numberToName[i] = name;
        }
        
        // M개의 문제를 처리
        for (int i = 0; i < M; i++) {
            String query = br.readLine();
            // 입력이 숫자인 경우 (포켓몬 번호를 입력받은 경우)
            if (Character.isDigit(query.charAt(0))) {
                int number = Integer.parseInt(query);
                bw.write(numberToName[number] + "\n");
            }
            // 입력이 문자인 경우 (포켓몬 이름을 입력받은 경우)
            else {
                bw.write(nameToNumber.get(query) + "\n");
            }
        }
        
        // 결과 출력
        bw.flush();
        bw.close();
        br.close();
    }
}
