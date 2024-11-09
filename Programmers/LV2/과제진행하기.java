import java.util.*;

class Task {
    public String name;
    public int duration;

    Task(String name, int duration) {
        this.name = name;
        this.duration = duration;
    }
}

class Solution {
    public String[] solution(String[][] plans) {
        Arrays.sort(plans, ((a, b) -> timeToInt(a[1]) - timeToInt(b[1])));
        
        List<String> result = new ArrayList<>();
        Stack<Task> s = new Stack<>();
        
        for (int i = 0; i < plans.length; i++) {
            String name = plans[i][0];
            int start = timeToInt(plans[i][1]);
            int playTime = Integer.parseInt(plans[i][2]);
            
            if (i == plans.length - 1) {
                result.add(name);
            } else {
                int nextTime = timeToInt(plans[i + 1][1]);
                int nowTime = nextTime - start;
                
                s.push(new Task(name, playTime));
                while (!s.isEmpty() && nowTime > 0) {
                    Task t = s.pop();
                    if (t.duration <= nowTime) {
                        result.add(t.name);
                        nowTime -= t.duration;
                    } else {
                        s.push(new Task(t.name, t.duration - nowTime));
                        nowTime = 0;
                    }
                }
            }
        }

        while (!s.isEmpty()) {
            result.add(s.pop().name);
        }
        
        return result.toArray(new String[0]);
    }
    
    public static int timeToInt(String time) {
        String[] arrTime = time.split(":");
        return Integer.parseInt(arrTime[0]) * 60 + Integer.parseInt(arrTime[1]);
    }
}