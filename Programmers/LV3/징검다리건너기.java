import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public int solution(int[] stones, int k) {
        int answer = Integer.MAX_VALUE;
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> b[0] - a[0]);
        
        for(int i = 0; i < stones.length; i++){
            q.offer(new int[]{stones[i],i});
            
            if(i >= k-1){
                while(!q.isEmpty() && q.peek()[1] < i - k + 1)
                    q.poll();
                answer = Math.min(answer, q.peek()[0]);
            }
        }

        return answer;
    }
}


// 처음 정직하게 시도한 것은 효율성 테스트에서 실패
// 그럼 k 개의 배열 중 가장 작은 것을 고르면 되지않을까??
// O(N)
// 일단 슬라이딩 윈도우