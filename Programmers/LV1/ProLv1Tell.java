class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder answer = new StringBuilder();
        int leftThumb = 10; // '*' 위치를 10으로 초기화
        int rightThumb = 12; // '#' 위치를 12로 초기화

        for (int number : numbers) {
            if (number == 0) number = 11; // 0의 위치를 11로 변경

            if (number % 3 == 1) { // 1, 4, 7인 경우
                answer.append("L");
                leftThumb = number;
            } else if (number % 3 == 0) { // 3, 6, 9인 경우
                answer.append("R");
                rightThumb = number;
            } else { // 2, 5, 8, 0인 경우
                int leftDistance = getDistance(leftThumb, number);
                int rightDistance = getDistance(rightThumb, number);

                if (leftDistance < rightDistance || (leftDistance == rightDistance && hand.equals("left"))) {
                    answer.append("L");
                    leftThumb = number;
                } else {
                    answer.append("R");
                    rightThumb = number;
                }
            }
        }

        return answer.toString();
    }

    private int getDistance(int thumb, int target) {
        int thumbX = (thumb - 1) / 3;
        int thumbY = (thumb - 1) % 3;
        int targetX = (target - 1) / 3;
        int targetY = (target - 1) % 3;

        return Math.abs(thumbX - targetX) + Math.abs(thumbY - targetY);
    }
}