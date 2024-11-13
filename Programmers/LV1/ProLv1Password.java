class Solution {
    public String solution(String s, String skip, int index) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            for (int j = 0; j < index;) {
                if (ch == 'z') //[A]ch가 z라면 a로 이동시켜줘야 한다. 
                    ch = 'a';
                else 
                    ch = (char) ((int) ch + 1);
		if(!skip.contains(String.valueOf(ch)))
                	j++;
            }
            answer += ch;
        }
        return answer;
    }
}