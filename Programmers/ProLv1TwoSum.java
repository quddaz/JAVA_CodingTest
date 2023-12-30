import java.util.HashSet;
import java.util.stream.IntStream;

class Solution {
    public int[] solution(int[] numbers) {
        HashSet<Integer> hs = new HashSet<>();

        IntStream.range(0, numbers.length)
            .flatMap(i -> IntStream.range(i + 1, numbers.length).map(j -> numbers[i] + numbers[j]))
            .forEach(hs::add);

        return hs.stream().sorted().mapToInt(Integer::intValue).toArray();
    }
}