class Solution {
    public int solution(String s) {
        int answer = 1; //최소 1개의 문자열 덩어리가 존재
        char first = s.charAt(0); // 첫 번째 단어 저장 
        int same = 1; //같을 때 이미 1개를 저장했으므로 
        int different = 0; //다를 때 
        for(int i = 1; i < s.length()-1; i++){
            if(first == s.charAt(i))
                same++;
            else    
                different++;
            if(same == different){
                first = s.charAt(i+1);
                answer++;
                same = 0;
                different = 0;
            }

        }
        return answer;
    }
}