import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
 
class Solution {
    public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for (int i = 1; i <= 10; i++) {
            int dump = Integer.parseInt(br.readLine().trim());
            int[] map = new int[100];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 100; j++) {
                map[j] = Integer.parseInt(st.nextToken());
            }
 
            // 덤프가 남아 있는 동안 작업 수행
            while (dump > 0) {
                // 배열을 정렬하고 최대값과 최소값을 조정
                Arrays.sort(map);
                map[99]--;  // 최대값 감소
                map[0]++;   // 최소값 증가
                dump--;
            }
 
            // 결과 출력 (최종 높이 차이 출력)
            Arrays.sort(map);
            System.out.println("#"+ i +" " + (map[99] - map[0]));
        }
    }
}