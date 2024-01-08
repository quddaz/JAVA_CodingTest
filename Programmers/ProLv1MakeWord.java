class Solution {
    public String solution(String s) {
        String answer = "";
        String[] str = s.split(" ",-1);
        for(int i =0; i < str.length;i++){
            String temp = "";
            for(int j = 0; j < str[i].length();j++){
                if(j%2 == 0){
                    temp += String.valueOf(str[i].charAt(j)).toUpperCase();
                }
                else
                    temp += String.valueOf(str[i].charAt(j)).toLowerCase();
            }
            str[i] = temp;
        }
        return String.join(" ", str);
    }
}