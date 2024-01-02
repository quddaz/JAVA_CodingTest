import java.util.ArrayList;
class Solution {
    public int[] solution(int[] answers) {
        int[][] role = {{1,2,3,4,5},{2,1,2,3,2,4,2,5},{3,3,1,1,2,2,4,4,5,5}};
        int[] check = new int[3];

        for (int i = 0; i < role.length; i++) {
            int count = 0;
            int pointer = 0;
            for (Integer answer : answers) {
                if (role[i][pointer] == answer) {
                    count++;
                }
                pointer = (pointer + 1) % role[i].length;
            }
            check[i] = count;
        }
        int maxCount = Math.max(check[0],Math.max(check[1],check[2]));
        ArrayList<Integer> resultList = new ArrayList<>();
        for (int i = 0; i < check.length; i++) {
            if (check[i] == maxCount) {
                resultList.add(i + 1);
            }
        }
        int[] answer = new int[resultList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = resultList.get(i);
        }

        return answer;
    }
}