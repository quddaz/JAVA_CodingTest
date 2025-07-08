import java.util.Arrays;
import java.util.Comparator;
class Solution {
    public String solution(int[] numbers) {
        String[] numStr = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            numStr[i] = String.valueOf(numbers[i]);
        }

        Arrays.sort(numStr, (a, b) -> (b + a).compareTo(a + b));

        // 길이 1, 원소 0일때
        if (numStr[0].equals("0")) {
            return "0";
        }

        StringBuilder result = new StringBuilder();
        for (String s : numStr) {
            result.append(s);
        }

        return result.toString();
    }
}

/*
* 정렬할 때 두개를 이어붙여서 더 큰 수로 정렬하면 된다.
*/