class Solution {
    public int solution(String t, String p) {
        int leng = p.length();
        int answer = 0;
        int count = t.length() - leng+ 1;
        for (int i = 0; i < count ; i++) {
            String temp = "";
            for (int j = 0; j < leng; j++) {
                temp += t.charAt(i + j);
            }
            if(Long.parseLong(temp) <= Long.parseLong(p)) {
                answer++;
            }
        }
        return answer;
    }
}