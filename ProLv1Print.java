class Solution {
    public int solution(int n, int m, int[] section) {
        int answer = 0;
        int first =  Integer.MIN_VALUE; //칠한 기준 위치를 표시하는 비교 수
        for(int sec:section){
            if(first+m <= sec){ //전에 칠한 부분에 룰러의 길이를 더했을 때 값이 작다면 처리에서 제외
                first = sec;
                answer++;
            }

        }
        return answer;
    }
}