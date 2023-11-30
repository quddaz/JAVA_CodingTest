import java.util.HashMap;


class Solution {
    public String[] solution(String[] players, String[] callings) {
        HashMap<String, Integer> map = new HashMap<>();
        for(int i =0; i < players.length;i++)
            map.put(players[i],i);
        for(String call:callings){
            int rank = map.get(call);  
            String tmp = call;
            players[rank] = players[rank-1];
            players[rank-1]= tmp;

            map.put(call, rank-1);
            map.put(players[rank], rank);
        }  
        return players;
    }
}
