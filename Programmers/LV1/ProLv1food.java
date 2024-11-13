class Solution {
    public String solution(int[] food) {
        String answer = "";
        for(int i = 1; i < food.length;i++){
            for(int j= 0; j < food[i]/2;j++){
                answer += Integer.toString(i);
            }
        }
        String temp = answer;
        answer += "0";
        for(int i = temp.length()-1; i >= 0; i--){
            answer += Character.toString(temp.charAt(i));
        }
        return answer;
    }
}