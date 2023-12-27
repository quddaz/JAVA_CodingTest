import java.util.ArrayList;
import java.util.HashMap;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        ArrayList<String> report_List;
        HashMap<String, Integer> count_Map = new HashMap<>();
        HashMap<String, ArrayList<String>> id_Map = new HashMap<>();

        int[] answer = new int[id_list.length];

        for (String id : id_list) {
            id_Map.put(id, new ArrayList<>());
            count_Map.put(id, 0);
        }

        for (String r : report) {
            String[] words = r.split(" ");
            String reporter = words[0];
            String reported = words[1];
            ArrayList<String> al = id_Map.get(reporter);
            if(!al.contains(reported)){
                id_Map.get(reporter).add(reported);
                count_Map.put(reported, count_Map.get(reported)+1);
            }
        }

        for(int i = 0; i<answer.length; i++){
            ArrayList<String> al = id_Map.get(id_list[i]);
            answer[i] = 0;
            for(String word : al){
                if(count_Map.get(word) >= k){
                    answer[i]+= 1;
                }
            }
        }
        return answer;
    }
}

/*
 * 1. 메시지를 날리기 위한 신고한 사람 저장 
 * 2. 신고 당한 횟수를 저장하는 배열 필요
 */ 