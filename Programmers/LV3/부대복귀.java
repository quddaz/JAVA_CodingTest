import java.util.*;
class Solution {
    static List<List<Integer>> li = new ArrayList<>();
    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        // 리스트 초기화
        for(int i = 0; i <= n; i++){
            li.add(new ArrayList<>());
        }
        // 로드 추가 
        for(int[] road : roads){
            li.get(road[0]).add(road[1]);
            li.get(road[1]).add(road[0]);
        }
        
        int result[] = new int[n + 1];
        Arrays.fill(result, -1);
        bfs(result, destination);
            
        int answer[] = new int[sources.length];
        for(int i = 0; i < sources.length; i++){
            answer[i] = result[sources[i]];
        }
        return answer;
    }
    public static void bfs(int result[], int start){
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{start, 0});
        result[start] = 0;
        
        while(!q.isEmpty()){
            int arr[] = q.poll();
            int de = arr[0];
            int count = arr[1];
            
            for(int num : li.get(de)){
                if(result[num] == -1){
                    result[num] = count + 1;
                    q.add(new int[]{num, count + 1});
                }
            }
        }
    }
}
