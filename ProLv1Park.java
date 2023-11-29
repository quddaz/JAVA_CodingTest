class Solution {
    public int[] solution(String[] park, String[] routes) {
        char[][] parkArr = new char[park.length][park[0].length()];
        int maxX = park[0].length() - 1;
        int maxY = park.length - 1;
        int dogX = 0;
        int dogY = 0;

        for (int i = 0; i < park.length; i++) {
            for (int j = 0; j < park[i].length(); j++) {
                parkArr[i][j] = park[i].charAt(j);
                if (parkArr[i][j] == 'S') {
                    dogX = j;
                    dogY = i;
                }
            }
        }

        for (String route : routes) {
            char direction = route.charAt(0);
            int move_count = Integer.parseInt(String.valueOf(route.charAt(2)));

            // 초기 위치 저장
            int tmpX = dogX;
            int tmpY = dogY;

            switch (direction) {
                case 'E':
                    for (int i = 0; i < move_count; i++) {
                        if (dogX + 1 > maxX || parkArr[dogY][dogX + 1] == 'X') {
                            dogX = tmpX;
                            break;
                        }
                        dogX += 1;
                    }
                    break;
                case 'W':
                    for (int i = 0; i < move_count; i++) {
                        if (dogX - 1 < 0 || parkArr[dogY][dogX - 1] == 'X') {
                            dogX = tmpX;
                            break;
                        }
                        dogX -= 1;
                    }
                    break;
                case 'N':
                    for (int i = 0; i < move_count; i++) {
                        if (dogY - 1 < 0 || parkArr[dogY - 1][dogX] == 'X') {
                            dogY = tmpY;
                            break;
                        }
                        dogY -= 1;
                    }
                    break;
                case 'S':
                    for (int i = 0; i < move_count; i++) {
                        if (dogY + 1 > maxY || parkArr[dogY + 1][dogX] == 'X') {
                            dogY = tmpY;
                            break;
                        }
                        dogY += 1;
                    }
                    break;
            }
        }

        int[] answer = new int[]{dogY, dogX};
        return answer;
    }
}