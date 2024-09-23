import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> bridge = new LinkedList<>();
        int bridge_weight = 0;
        int time = 0;

        for (int i = 0; i < bridge_length; i++) {
            bridge.add(0);
        }

        int truck_index = 0;
        while (truck_index < truck_weights.length) {
            int truck = bridge.poll();
            bridge_weight -= truck;

            if (bridge_weight + truck_weights[truck_index] <= weight) {
                bridge.add(truck_weights[truck_index]);
                bridge_weight += truck_weights[truck_index];
                truck_index++;
            } else {
                bridge.add(0);
            }

            time++;
        }
        //마지막 트럭 시간 계산
        time += bridge_length;

        return time;
    }
}

/*
 * 1. 큐를 이용하여 다리를 시뮬레이션한다.
 * 2. 1초마다 1m이동 길이가 걸리는 시간
 * 3. 시간 측정을 위해 변수 하나를 더 둬야하지만 모든 것을 둘 수 는 없음...
 * 4. 큐를 전부 0으로 채워놓고 회전초밥처럼 처리하면 되지 않을까?
 */