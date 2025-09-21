class Solution {
    public String solution(String new_id) {
        // 1단계: 모든 대문자를 소문자로 변환
        String id = new_id.toLowerCase();

        // 2단계: 알파벳 소문자, 숫자, 빼기(-), 밑줄(_), 마침표(.)를 제외한 모든 문자 제거
        id = id.replaceAll("[^0-9a-z_.-]", "");

        // 3단계: 연속된 마침표(.)를 하나의 마침표(.)로 변경
        id = id.replaceAll("\\.+", ".");

        // 4단계: 처음이나 끝에 위치한 마침표(.) 제거
        if (id.startsWith(".")) id = id.substring(1);
        if (id.endsWith(".")) id = id.substring(0, id.length() - 1);

        // 5단계: 빈 문자열이면 "a" 대입
        if (id.isEmpty()) id = "a";

        // 6단계: 길이가 16자 이상이면 처음 15개 문자만 남기고, 끝이 '.'이면 제거
        if (id.length() >= 16) {
            id = id.substring(0, 15);
            if (id.endsWith(".")) id = id.substring(0, 14);
        }

        // 7단계: 길이가 2자 이하라면 마지막 문자를 3자가 될 때까지 반복 추가
        while (id.length() < 3) {
            id += id.charAt(id.length() - 1);
        }

        return id;
    }
}