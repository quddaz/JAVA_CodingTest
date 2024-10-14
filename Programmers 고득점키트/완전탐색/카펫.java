import java.util.stream.IntStream;

public class Solution {
    public int[] solution(int brown, int yellow) {
        int total = brown + yellow;

        return IntStream.rangeClosed(3, total / 3) // 최소 높이 3부터 total / 3까지 순회
                .filter(height -> total % height == 0) // 전체 타일 개수로 나누어 떨어지는 높이만 필터링
                .mapToObj(height -> new int[]{total / height, height}) // 나누어 떨어지면 {width, height} 생성
                .filter(dim -> (dim[0] - 2) * (dim[1] - 2) == yellow) // 조건에 맞는 (width, height) 찾기
                .findFirst() // 첫 번째로 찾은 결과 반환
                .orElse(new int[]{}); // 없으면 빈 배열 반환
    }
}