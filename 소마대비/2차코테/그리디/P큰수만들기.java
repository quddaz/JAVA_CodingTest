import java.util.*;
class Solution {
    public String solution(String number, int k) {
        Stack<Integer> s = new Stack<>();
        for(int i = 0; i < number.length(); i++){
            int cnt = number.charAt(i) - '0';
            while(!s.isEmpty() && k > 0 && cnt > s.peek()){
                s.pop();
                k--;
            }
            s.push(cnt);
        }
        while(!s.isEmpty() && k > 0){
            s.pop();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        while(!s.isEmpty()){
            sb.append(s.pop());
        }
        sb.reverse();
        
        return sb.toString();
    }
}