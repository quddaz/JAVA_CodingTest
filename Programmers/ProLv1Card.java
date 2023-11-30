import java.util.Vector;

class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        Vector<String> card1 = new Vector<>();
        Vector<String> card2 = new Vector<>();
        
        // card1에 요소 추가
        for(String card : cards1)
            card1.add(card);
        
        // card2에 요소 추가
        for(String card : cards2)
            card2.add(card);
        
        // goal 확인
        for(String target : goal){
            if(card1.size() > 0 && card1.get(0).equals(target))
                card1.remove(0);
            else if(card2.size() > 0 && card2.get(0).equals(target))
                card2.remove(0);
            else
                return "No";
        }
        return "Yes";
    }
}
