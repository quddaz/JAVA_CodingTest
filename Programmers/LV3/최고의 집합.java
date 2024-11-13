class Solution {
    public int[] solution(int n, int s) {
        int[] answer = new int[n];
        // n보다 s가 작으면 집합으로 못나눔
        if(n > s)
            return new int[]{-1};
        
        int idx = 0;
        while(n > 0){
            int num = s / n;
            answer[idx++] = num;
            s -= num;
            n--;
        }
        return answer;
    }
}

//1. 최고의 곱이 나오는 조건은 더했을때 균등한 값들로 더하는 것이라 생각
//2. 자연수 S를 N으로 나누고 하면 되지 않을까??