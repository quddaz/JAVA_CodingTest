class Solution {
    public String solution(String new_id) {
        // 1단계: 소문자로 치환 
        String first_id = new_id.toLowerCase();

        // 2단계: 유효한 문자 제외 모두 제거
        StringBuilder second_id = new StringBuilder();
        for (int i = 0; i < first_id.length(); i++) {
            char ch = first_id.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= '0' && ch <= '9') || ch == '-' || ch == '_' || ch == '.') {
                second_id.append(ch);
            }
        }

        // 3단계: 연속 마침표 제거
        StringBuilder third_id = new StringBuilder();
        char temp = '.';
        for (int i = 0; i < second_id.length(); i++) {
            char ch = second_id.charAt(i);
            if (temp == '.' && ch == '.') {
                continue;
            }
            third_id.append(ch);
            temp = ch;
        }

        // 4단계: 처음과 끝 마침표 제거  
        if (third_id.length() > 0 && third_id.charAt(0) == '.') {
            third_id.deleteCharAt(0);
        }
        if (third_id.length() > 0 && third_id.charAt(third_id.length() - 1) == '.') {
            third_id.deleteCharAt(third_id.length() - 1);
        }

        // 5단계: 만약 빈 문자열이라면 'a'를 대입
        if (third_id.length() == 0) {
            third_id.append('a');
        }

        // 6단계: 길이가 16자 이상이면, 첫 15개의 문자를 제외한 나머지를 모두 지움
        if (third_id.length() >= 16) {
            third_id.setLength(15);
            if (third_id.charAt(third_id.length() - 1) == '.') {
                third_id.deleteCharAt(third_id.length() - 1);
            }
        }

        // 7단계: 길이가 2자 이하라면 마지막 문자를 길이가 3이 될 때까지 반환
        while (third_id.length() <= 2) {
            third_id.append(third_id.charAt(third_id.length() - 1));
        }

        String answer = third_id.toString();
        return answer;
    }
}