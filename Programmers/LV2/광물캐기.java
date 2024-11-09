class Solution {
    static int answer = Integer.MAX_VALUE; 
    static int length = 0;

    public int solution(int[] picks, String[] minerals) {
        length = minerals.length;
        int[] mineralValue = new int[length];

        // 광물 값 변환
        for (int i = 0; i < length; i++) {
            switch (minerals[i]) {
                case "diamond":
                    mineralValue[i] = 25;
                    break;
                case "iron":
                    mineralValue[i] = 5;
                    break;
                case "stone":
                    mineralValue[i] = 1;
                    break;
            }
        }

        // dfs로 최소 피로도 계산
        dfs(picks, mineralValue, 0, 0);

        return answer;
    }

    private void dfs(int[] picks, int[] mineralValue, int index, int result) {
        // 모든 광물을 다 캐거나, 곡괭이가 더 이상 없으면 최소 피로도 갱신
        if (index >= length) {
            answer = Math.min(answer, result);
            return;
        }

        // 곡괭이가 모두 소진되면 종료
        boolean noMorePicks = true;
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] > 0) {
                noMorePicks = false;
                break;
            }
        }
        if (noMorePicks) {
            answer = Math.min(answer, result);
            return; // 더 이상 사용할 곡괭이가 없으면 종료
        }

        // 곡괭이를 하나씩 사용하며 진행
        for (int i = 0; i < picks.length; i++) {
            if (picks[i] > 0) { // 해당 곡괭이가 남아있다면
                int endPoint = Math.min(5, length - index); // 한 번에 처리할 최대 5개의 광물
                int nextFatigue = result;

                // 광물 5개에 대한 피로도 계산
                for (int j = 0; j < endPoint; j++) {
                    int currentMineral = mineralValue[index + j];
                    switch (i) {
                        case 0: // 다이아 곡괭이
                            nextFatigue += 1;
                            break;
                        case 1: // 철 곡괭이
                            if (currentMineral == 1) nextFatigue += 1;
                            else nextFatigue += currentMineral/5;
                            break;
                        case 2: // 돌 곡괭이
                            nextFatigue += currentMineral;
                            break;
                    }
                }

                // 곡괭이 사용 후 재귀적으로 진행
                picks[i]--; // 곡괭이 사용
                dfs(picks, mineralValue, index + endPoint, nextFatigue); // 다음 광물로 이동
                picks[i]++; // 곡괭이 복구
            }
        }
    }
}
