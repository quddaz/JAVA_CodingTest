import java.util.HashSet;

class Solution {
    static boolean[] isPrime;

    // 소수 판별 함수 (에라토스테네스의 체)
    static void isPrime_fun(int n) {
        isPrime = new boolean[n + 1];
        isPrime[0] = isPrime[1] = true; 
        for (int i = 2; i <= Math.sqrt(n); i++) { 
            if (!isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = true;
                }
            }
        }
    }

    // 모든 자리 수의 조합 생성
    private void generatePermutations(char[] arr, String current, boolean[] visited, HashSet<Integer> nums) {
        if (!current.isEmpty()) {
            nums.add(Integer.parseInt(current));
        }
        for (int i = 0; i < arr.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                generatePermutations(arr, current + arr[i], visited, nums);
                visited[i] = false;
            }
        }
    }

    public int solution(String numbers) {
        char[] arr = numbers.toCharArray();
        HashSet<Integer> nums = new HashSet<>();

        generatePermutations(arr, "", new boolean[arr.length], nums);

        int max = nums.stream().max(Integer::compare).orElse(0);

        isPrime_fun(max);

        int answer = 0;
        for (Integer num : nums) {
            if (num > 1 && !isPrime[num]) { 
                answer++;
            }
        }
        return answer;
    }
}


// 1. 주어진 수로 숫자 조합 만들기
// 2. 에라토스테네스의 채 사용하여 소수 완성