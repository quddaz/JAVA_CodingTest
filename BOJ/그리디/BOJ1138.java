import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine().trim()); // 사람의 수 입력
        StringTokenizer st = new StringTokenizer(br.readLine()); // 각 사람이 기억하는 정보 입력
        
        int[] tallerCount = new int[n];
        for (int i = 0; i < n; i++) {
            tallerCount[i] = Integer.parseInt(st.nextToken());
        }

        int[] result = new int[n];

        // 각 사람이 자신이 기억하는 사람의 수만큼 위치를 찾아서 result 배열에 삽입
        for (int i = 0; i < n; i++) {
            int count = tallerCount[i]; // 자신보다 큰 사람의 수
            for (int j = 0; j < n; j++) {
                if (result[j] == 0) { // 아직 배정되지 않은 위치일 때
                    if (count == 0) {
                        result[j] = i + 1; // i+1은 실제 사람의 번호 (1부터 시작)
                        break;
                    }
                    count--;
                }
            }
        }

        // 결과 출력
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb.toString().trim());
    }
}


/*
N명의 사람들은 매일 아침 한 줄로 선다.
이 사람들은 자리를 마음대로 서지 못하고 지시대로 선다.
어느 날 사람들은 줄 서는 위치를 기록해 놓는다는 것을 알앗다.
그리고 아침에 자기가 기록 해놓은 것과 사람들이 줄을 선 위치가 맞는지 확인한다.

사람들은 자기보다 큰 사람이 왼쪽에 몇 명 있었는지만을 기억한다.

각 사람들이 기억하는 정보가 주어질 때 줄을 어떻게 서야 하는가 
 */