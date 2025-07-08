import java.util.HashSet;

class Solution {
    public int solution(int[] nums) {
        HashSet<Integer> hs = new HashSet<>();
        int count = nums.length/2;
        for(Integer num : nums)
            hs.add(num);
        if(count <= hs.size())
            return count;
        else
            return hs.size();
    }
}