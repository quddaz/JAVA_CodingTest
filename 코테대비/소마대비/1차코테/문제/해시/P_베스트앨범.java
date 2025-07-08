import java.util.*;
class Solution {
    public static class Sing{
        String genre;
        int play;
        int num;
        Sing(String genre, int play, int num){
            this.genre = genre;
            this.play = play;
            this.num = num;
        }
    }
    public int[] solution(String[] genres, int[] plays) {
        Map<String, Integer> genresTotal = new HashMap<>();
        List<Sing> arr = new ArrayList<>();
        
        for(int i = 0; i < genres.length; i++){
            genresTotal.put(genres[i], genresTotal.getOrDefault(genres[i], 0) + plays[i]);
            arr.add(new Sing(genres[i], plays[i], i));
        }
        
        arr.sort((a,b) -> {
            int acount = genresTotal.get(a.genre);
            int bcount = genresTotal.get(b.genre);
            if(acount == bcount){
                if(a.play == b.play)
                    return a.num - b.num;
                else
                    return b.play - a.play;
            }
            return bcount - acount;
        });
        
        List<Integer> result = new ArrayList<>();
        Map<String,Integer> temp = new HashMap<>();
        for(Sing sing : arr){
            if(temp.getOrDefault(sing.genre,0) < 2){
                result.add(sing.num);
            }
            temp.put(sing.genre, temp.getOrDefault(sing.genre,0) + 1);
        }
        
        return result.stream().mapToInt(i -> i).toArray();
    }
}