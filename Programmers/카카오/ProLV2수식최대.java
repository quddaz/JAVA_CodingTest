import java.util.*;

public class Solution {

    static long maxResult = 0;

    public long solution(String expression) {
        List<Long> numbers = new ArrayList<>();
        List<Character> operators = new ArrayList<>();
        Set<Character> opSet = new HashSet<>();

        String numStr = "";
        for (char c : expression.toCharArray()) {
            if (c == '+' || c == '-' || c == '*') {
                numbers.add(Long.parseLong(numStr));
                numStr = "";
                operators.add(c);
                opSet.add(c);
            } else {
                numStr += c;
            }
        }
        numbers.add(Long.parseLong(numStr));

        List<Character> uniqueOps = new ArrayList<>(opSet);
        List<List<Character>> opPermutations = new ArrayList<>();
        permute(uniqueOps, 0, opPermutations);

        for (List<Character> opOrder : opPermutations) {
            List<Long> tmpNums = new ArrayList<>(numbers);
            List<Character> tmpOps = new ArrayList<>(operators);

            for (char op : opOrder) {
                for (int i = 0; i < tmpOps.size(); ) {
                    if (tmpOps.get(i) == op) {
                        long res = calc(tmpNums.get(i), tmpNums.get(i + 1), op);
                        tmpNums.remove(i + 1);
                        tmpNums.set(i, res);
                        tmpOps.remove(i);
                    } else {
                        i++;
                    }
                }
            }
            maxResult = Math.max(maxResult, Math.abs(tmpNums.get(0)));
        }

        return maxResult;
    }

    private long calc(long a, long b, char op) {
        switch (op) {
            case '+': return a + b;
            case '-': return a - b;
            case '*': return a * b;
        }
        return 0;
    }

    private void permute(List<Character> list, int start, List<List<Character>> result) {
        if (start == list.size() - 1) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = start; i < list.size(); i++) {
            Collections.swap(list, start, i);
            permute(list, start + 1, result);
            Collections.swap(list, start, i);
        }
    }
}
