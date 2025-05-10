import java.io.*;
import java.util.*;

public class Main {
    static LinkedList<Character>[] gears = new LinkedList[4];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 톱니 상태 입력
        for (int i = 0; i < 4; i++) {
            gears[i] = new LinkedList<>();
            String line = br.readLine();
            for (int j = 0; j < 8; j++) {
                gears[i].add(line.charAt(j));
            }
        }

        int K = Integer.parseInt(br.readLine());
        for (int k = 0; k < K; k++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int gearNum = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());

            int[] rotateDirs = new int[4];
            rotateDirs[gearNum] = dir;

            // 왼쪽 확인
            for (int i = gearNum - 1; i >= 0; i--) {
                if (gears[i].get(2) != gears[i + 1].get(6)) {
                    rotateDirs[i] = -rotateDirs[i + 1];
                } else {
                    break;
                }
            }

            // 오른쪽 확인
            for (int i = gearNum + 1; i < 4; i++) {
                if (gears[i - 1].get(2) != gears[i].get(6)) {
                    rotateDirs[i] = -rotateDirs[i - 1];
                } else {
                    break;
                }
            }

            // 회전 수행
            for (int i = 0; i < 4; i++) {
                if (rotateDirs[i] == 1) {
                    gears[i].addFirst(gears[i].removeLast());
                } else if (rotateDirs[i] == -1) {
                    gears[i].addLast(gears[i].removeFirst());
                }
            }
        }

        // 점수 계산
        int score = 0;
        for (int i = 0; i < 4; i++) {
            if (gears[i].get(0) == '1') {
                score += (1 << i); // 2^i
            }
        }

        System.out.println(score);
    }
}
