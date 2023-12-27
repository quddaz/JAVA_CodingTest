import java.util.HashMap;
class Solution {
    public String solution(String[] survey, int[] choices) {
        String[] surveyArr = {"R","T","C","F","J","M","A","N"}; 
        HashMap<String,Integer> map = new HashMap<>();
        String answer = "";
        for(String sur:surveyArr)
            map.put(sur,0);

        for(int i = 0; i < choices.length;i++){
            if(choices[i]==4)
                continue;
            else if(choices[i] > 4){
                String word = String.valueOf(survey[i].charAt(1));
                map.put(word, map.get(word) + choices[i]-4);
            }
            else{
                String word = String.valueOf(survey[i].charAt(0));
                map.put(word, map.get(word) + 4 -choices[i]);
            }
                
        }
        answer += map.get("R") >= map.get("T") ? "R" : "T";
        answer += map.get("C") >= map.get("F") ? "C" : "F";
        answer += map.get("J") >= map.get("M") ? "J" : "M";
        answer += map.get("A") >= map.get("N") ? "A" : "N";  
        return answer;
    }
}



/*
 * 성격 유형 4가지 
 * 1. R T
 * 2. C F
 * 3. J M
 * 4. A N
 */