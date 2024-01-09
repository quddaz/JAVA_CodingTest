import java.util.HashMap;

class Solution {
    public int solution(String[] friends, String[] gifts) {
        HashMap<String, Integer> giftScore = new HashMap<>(); // 선물 지수
        HashMap<String, HashMap<String, Integer>> giftCount = new HashMap<>(); // 주고 받은 기록

        // 초기화
        for (String friend : friends) {
            giftScore.put(friend, 0);
            HashMap<String, Integer> friendGiftCount = new HashMap<>();
            for (String friend2 : friends) {
                if (!friend.equals(friend2)) {
                    friendGiftCount.put(friend2, 0);
                }
            }
            giftCount.put(friend, friendGiftCount);
        }

        // 선물 기록 업데이트
        for (String gift : gifts) {
            String[] temp = gift.split(" ");
            HashMap<String, Integer> senderGiftCount = giftCount.get(temp[0]);
            senderGiftCount.put(temp[1], senderGiftCount.get(temp[1]) + 1);
            giftCount.put(temp[0], senderGiftCount);

            // 선물 지수 업데이트
            giftScore.put(temp[0], giftScore.get(temp[0]) + 1);
            giftScore.put(temp[1], giftScore.get(temp[1]) - 1);
        }

        int answer = 0;

        // 친구 간 비교
        for (String friend : friends) {
            int count = 0;
            for (String friend2 : friends) {
                if (!friend.equals(friend2)) {
                    int hasGivenGift = giftCount.get(friend).get(friend2);
                    int hasReceivedGift = giftCount.get(friend2).get(friend);
                    if (hasGivenGift > hasReceivedGift || (hasGivenGift == hasReceivedGift && giftScore.get(friend) > giftScore.get(friend2))) {
                        count++;
                    }
                }
            }
            answer = Math.max(answer, count);
        }

        return answer;
    }
}
