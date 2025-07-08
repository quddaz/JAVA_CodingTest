import java.util.*;
class Solution {
    public int solution(int n, int[][] edge) {
        List<List<Integer>> li = new ArrayList<>();
        int[] map = new int[n + 1];
        Arrays.fill(map, -1);
        
        for(int i = 0; i <= n; i++){
            li.add(new ArrayList<>());
        }
        
        for(int[] edg : edge){
            li.get(edg[0]).add(edg[1]);
            li.get(edg[1]).add(edg[0]);
        }
        
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{1, 0});
        map[1] = 0;
        while(!q.isEmpty()){
            int arr[] = q.poll();
            int num = arr[0];
            int count = arr[1];
            
            for(Integer ed : li.get(num)){
                if(map[ed] == -1){
                    map[ed] = count + 1;
                    q.add(new int[]{ed, count + 1});
                }
            }
        }
        
        int max = 0;
        for(int i = 0; i <= n ; i++){
            if(map[i] > max && map[i] != -1)
                max = map[i];
        }
        
        int answer = 0;
        for(int ma : map){
            if(ma == max)
                answer++;
        }
        return answer;
    }

}