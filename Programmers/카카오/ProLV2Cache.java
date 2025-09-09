import java.util.*;
class Solution {
    public static int solution(int cacheSize, String[] cities) {
        if (cacheSize == 0) return cities.length * 5;

        LinkedList<String> cache = new LinkedList<>();
        int time = 0;

        for (String city : cities) {
            city = city.toLowerCase();

            if (cache.remove(city)) {
                time += 1;
                cache.addLast(city); 
            } else { 
                time += 5;
                if (cache.size() == cacheSize) {
                    cache.removeFirst(); 
                }
                cache.addLast(city);
            }
        }
        return time;
    }
}