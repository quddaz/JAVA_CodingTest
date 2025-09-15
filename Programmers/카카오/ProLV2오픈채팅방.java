import java.util.*;

class Solution {
    class Message{
        int type; // 1은 입장 2는 퇴장
        String uid;
        
        Message(int type, String uid){
            this.type = type;
            this.uid = uid;
        }
    }
    public String[] solution(String[] record) {
        Map<String, String> m = new HashMap<>();
        List<Message> result = new ArrayList<>();
        
        for(String re : record){
            String cnt[] = re.split(" ");
            
            if(cnt[0].equals("Enter")){
                result.add(new Message(1,cnt[1]));  
                m.put(cnt[1], cnt[2]);
            }else if(cnt[0].equals("Leave")){
                result.add(new Message(2,cnt[1]));
            }else{
                m.put(cnt[1], cnt[2]);
            }
        }
        
        String answer[] = new String[result.size()];
        
        for(int i = 0; i < result.size(); i++){
            Message cnt = result.get(i);
            if(cnt.type == 1){
                answer[i] = m.get(cnt.uid) + "님이 들어왔습니다.";
            }else{
                answer[i] = m.get(cnt.uid) + "님이 나갔습니다.";
            }
        }
        return answer;
    }
}