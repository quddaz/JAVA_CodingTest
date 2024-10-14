import java.util.ArrayList;
import java.util.List;
public class Solution {
    static char[] vowels = {'A', 'E', 'I', 'O', 'U'};
    static List<String> words = new ArrayList<>();
    
    public static int solution(String word) {
        makeWords("");
        return words.indexOf(word);
    }
    
    static void makeWords(String word){
        words.add(word);
        if(word.length() == 5) return;
        
        for(char c : vowels){
            makeWords(word + c);
        }
    }
}
