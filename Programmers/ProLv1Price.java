import java.util.stream.LongStream;

class Solution {
    public long solution(int price, int money, int count) {
        long total_price = LongStream.rangeClosed(1, count)
            .map(i -> price * i)
            .sum();

        return Math.max(total_price - money, 0);
    }
}