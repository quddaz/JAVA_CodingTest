import java.util.ArrayList;

class Solution {
    public int solution(int[] ingredient) {
        StringBuilder sb = new StringBuilder();
        int answer = 0;

        for (Integer num : ingredient)
            sb.append(num);

        for (int i = 0; i < sb.length() - 3; ) {
            if (sb.charAt(i) == '1' && sb.charAt(i + 1) == '2' && sb.charAt(i + 2) == '3' && sb.charAt(i + 3) == '1') {
                sb.delete(i, i+4);
                answer++;
                if(i >=3)
                    i -= 3;
                else
                    i = 0;
            } else {
                i++;
            }
        }

        return answer;
    }
}