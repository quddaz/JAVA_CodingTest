class Solution {
    public int solution(int number, int limit, int power) {
        int answer = 0;
        for(int i = 1; i <= number; i++){
            int attack = 0; 
            for(int j = 1; j*j <= i; j++){
                if(i%j == 0){
                    attack++;
                    if(i/j != j)
                        attack++;
                }
            }
            if(attack > limit)
                answer += power;
            else    
                answer += attack;
        }
        return answer;
    }
}

/*
 * 1. number의 약수 갯수를 구한다.
 * 2. 갯수를 limit와 비교 후 저장 
 * 3. 시간초과 - 어느 부분에서 시간복잡도를 줄어야함. -> 약수 계산? -> 소인수분해
 */