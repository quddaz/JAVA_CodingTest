import java.util.*;
class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> li = new ArrayList<>();
        if(N == number) return 1;
        for (int i = 0; i <= 8; i++) {
            li.add(new HashSet<>());
        }
        
        for(int i = 1; i <= 8; i++){
            Set<Integer> s = li.get(i);
            
            int temp = N;
            for(int j = 1; j < i; j++){
                temp *= 10;
                temp += N;
            }
            s.add(temp);
            
            for(int x = 1; x < i; x++){
                Set<Integer> first = li.get(x);
                Set<Integer> second = li.get(i-x);
                for(int num1 : first){
                    for(int num2 : second){
                        s.add(num1 - num2);
                        s.add(num1 + num2);
                        s.add(num1 * num2);
                        if(num2 != 0)
                            s.add(num1 / num2);
                    }
                }
                if(s.contains(number)){
                    return i;
                }
            }
        }
        return -1;
    }
}