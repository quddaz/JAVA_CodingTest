import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();  // 지름길의 개수
        int D = sc.nextInt();  // 고속도로의 길이

        // 각 위치까지의 최소 거리를 저장하는 배열 (최대 D+1 크기)
        int[] dist = new int[D + 1];

        // 초기 거리 설정 (각각의 거리는 일단 최대로 설정)
        for (int i = 0; i <= D; i++) {
            dist[i] = i;
        }

        // 지름길 정보 저장
        ArrayList<int[]> shortcuts = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            int start = sc.nextInt();
            int end = sc.nextInt();
            int length = sc.nextInt();

            // 도착 위치가 D보다 작거나 같은 경우에만 지름길 추가
            if (end <= D) {
                shortcuts.add(new int[]{start, end, length});
            }
        }

        // 다익스트라와 유사한 방식으로 최소 거리 계산
        for (int i = 0; i <= D; i++) {
            if (i > 0) {
                // i번째 위치까지의 최단거리 갱신
                dist[i] = Math.min(dist[i], dist[i - 1] + 1);
            }

            // 지름길을 통해서 이동하는 경우의 최단거리 갱신
            for (int[] shortcut : shortcuts) {
                int start = shortcut[0];
                int end = shortcut[1];
                int length = shortcut[2];

                // 현재 위치에서 출발 가능한 지름길만 고려
                if (i == start && dist[i] + length < dist[end]) {
                    dist[end] = dist[i] + length;
                }
            }
        }

        // 최종적으로 도착 지점 D까지의 최단거리를 출력
        System.out.println(dist[D]);
    }
}
