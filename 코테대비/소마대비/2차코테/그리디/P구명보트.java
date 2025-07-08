import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int answer = 0;
        int left = 0;
        int right = people.length - 1;
        
        while(left <= right){
            while(left < right && people[left] + people[right] > limit){
                right--;
                answer++;
            }
            left++;
            right--;
            answer++;
        }
        return answer;
    }
}