import java.util.*;
class Solution {

    public int solution(int n, int[][] edge) {
        List<List<Integer>> graph = new ArrayList<>();
        
        int arr[] = new int[n + 1];
        arr[0] = -1;
        
        for(int i = 0; i <= n; i++){
            graph.add(new ArrayList<>());
        }
        for(int[] ed : edge){
            graph.get(ed[0]).add(ed[1]);
            graph.get(ed[1]).add(ed[0]);
        }
        
        Queue<int[]> q = new LinkedList<>();
        boolean visited[] = new boolean[n + 1];
        visited[1] = true;
        q.add(new int[]{1,0});
        
        while(!q.isEmpty()){
            int cnt[] = q.poll();
            
            for(int num : graph.get(cnt[0])){
                if(!visited[num]){
                    visited[num] = true;
                    q.add(new int[]{num, cnt[1] + 1});
                    arr[num] = cnt[1] + 1;
                }
            }
        }
        int max = 0;
        for(int num : arr){
            if(max < num)
                max = num;
        }
        
        int count = 0;
        for(int num : arr){
            if(max == num)
                count++;
        }
        return count;
    }
}