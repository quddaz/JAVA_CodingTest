import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<String, Integer> inMap = new HashMap<>(); 
        Map<String, Integer> totalMap = new HashMap<>(); 

        for (String record : records) {
            String[] parts = record.split(" ");
            String time = parts[0];
            String car = parts[1];
            String type = parts[2];

            int minutes = toMinutes(time);

            if (type.equals("IN")) {
                inMap.put(car, minutes);
            } else {
                int inTime = inMap.remove(car);
                int parkingTime = minutes - inTime;
                totalMap.put(car, totalMap.getOrDefault(car, 0) + parkingTime);
            }
        }

        int endOfDay = 23 * 60 + 59;
        for (String car : inMap.keySet()) {
            int inTime = inMap.get(car);
            int parkingTime = endOfDay - inTime;
            totalMap.put(car, totalMap.getOrDefault(car, 0) + parkingTime);
        }

        List<String> cars = new ArrayList<>(totalMap.keySet());
        Collections.sort(cars);

        int[] answer = new int[cars.size()];
        for (int i = 0; i < cars.size(); i++) {
            int totalTime = totalMap.get(cars.get(i));
            answer[i] = calcFee(fees, totalTime);
        }

        return answer;
    }

    private int toMinutes(String time) {
        String[] t = time.split(":");
        int h = Integer.parseInt(t[0]);
        int m = Integer.parseInt(t[1]);
        return h * 60 + m;
    }

    private int calcFee(int[] fees, int totalTime) {
        int baseTime = fees[0];
        int baseFee = fees[1];
        int unitTime = fees[2];
        int unitFee = fees[3];

        if (totalTime <= baseTime) {
            return baseFee;
        } else {
            int extra = totalTime - baseTime;
            int units = (extra + unitTime - 1) / unitTime; 
            return baseFee + units * unitFee;
        }
    }
}
