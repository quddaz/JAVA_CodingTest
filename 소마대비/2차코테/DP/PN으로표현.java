import java.util.*;

class Solution {
    public int solution(int N, int number) {
        List<Set<Integer>> li = new ArrayList<>();
        if(N == number) return 1;
        for (int i = 0; i <= 8; i++) {
            li.add(new HashSet<>());
        }

        li.get(1).add(N);
        for (int i = 2; i <= 8; i++) {
            Set<Integer> cnt = li.get(i);

            cnt.add(Integer.parseInt(String.valueOf(N).repeat(i)));

            for (int x = 1; x < i; x++) {
                Set<Integer> temp1 = li.get(x);
                Set<Integer> temp2 = li.get(i - x);

                for (int num1 : temp1) {
                    for (int num2 : temp2) {
                        cnt.add(num1 - num2);
                        cnt.add(num1 + num2);
                        cnt.add(num1 * num2);
                        if (num2 != 0) cnt.add(num1 / num2);
                    }
                }
            }

            if (cnt.contains(number)) {
                return i;
            }
        }

        return -1;
    }
}
