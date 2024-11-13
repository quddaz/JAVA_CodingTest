class Solution {
    public int[] solution(String[] wallpaper) {
        int minX = 9999;
        int maxX = 0;
        int minY = 9999;
        int maxY = 0; 
        for(int i = 0; i < wallpaper.length; i++){
            for(int j = 0; j < wallpaper[i].length();j++){
                if(wallpaper[i].charAt(j) == '#'){
                    if(minX > j)
                        minX = j;
                    if(maxX < j+1)
                        maxX = j+1;
                    if(minY > i)
                        minY = i;
                    if(maxY < i+1)
                        maxY = i+1;
                }
            }
        }
        int[] answer = {minY,minX,maxY,maxX};
        return answer;
    }
}
