import java.util.*;

class Main{
    public static void main(String[] args) {
        Scanner std = new Scanner(System.in);
        int N = std.nextInt();
        int arr[] = new int[N];
        for(int i = 0; i < N; i++){
            arr[i] = std.nextInt();
        }
        Arrays.sort(arr);
        // 내림차순으로 정렬
        Arrays.sort(arr);
        for (int i = 0; i < N; i++) {
            arr[i] *= (N - i); // 현재 로프 중 최소 중량 * 남은 로프 개수
        }

        // 최대 중량 출력
        int maxWeight = Arrays.stream(arr).max().getAsInt();
        System.out.println(maxWeight);
    }
}