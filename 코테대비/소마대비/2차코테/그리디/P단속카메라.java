import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes,(a,b) -> a[1] - b[1] );
        int load = Integer.MIN_VALUE;
        int count = 0;
        for(int[] route : routes){
            if(route[0] > load){
                count++;
                load = route[1];
            }
        }
        return count;
    }
}