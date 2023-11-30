import java.util.HashMap;

class Solution {
    public int[] solution(String[] keymap, String[] targets) {
        HashMap<Character, Integer> key = new HashMap<>();
        int[] answer = new int[targets.length]; 

        for (int i = 0; i < keymap.length; i++) {
            for (int j = 0; j < keymap[i].length(); j++) {
                char ch = keymep[i].charAt(j);

                if (key.containsKey(ch)) { 
                    if (key.get(ch) > j) //만약 키가 존재한다면 더 작은 값을 넣음
                        key.put(ch, j+1); //j+1을 하는 이유는 문제가 0번부터가 아닌 1번부터 시작하기 때문
                } else {
                    key.put(ch, j+1);
                }
            }
        }

        for (int i = 0; i < targets.length; i++) {
        	boolean err = true; //입력해야하는 단어를 구현 불가능한지 판별
            for (int j = 0; j < targets[i].length(); j++) {
                char ch = targets[i].charAt(j);
                
                if (key.containsKey(ch))
                   answer[i] += key.get(ch);   
                else
                    err = false;
            }
  			if(!err)
                answer[i] = -1;
        }

        return answer;
    }
