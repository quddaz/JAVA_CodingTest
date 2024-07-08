import java.io.*;
import java.util.*;

class Main {
    static int arr[];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        solve();
    }

    public static void solve() {
        int i = arr.length - 2;

        // 피벗 포인트 찾기
        while (i >= 0 && arr[i] <= arr[i + 1]) {
            i--;
        }

        // 가장 작은 순열인 경우 -1 출력
        if (i < 0) {
            System.out.println(-1);
            return;
        }

        // arr[i]보다 큰 가장 작은 수 찾기
        int j = arr.length - 1;
        while (arr[j] >= arr[i]) {
            j--;
        }

        // arr[i]와 arr[j]를 교환
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // arr[i+1]부터 배열의 끝까지 내림차순으로 정렬
        reverse(arr, i + 1, arr.length);

        // 이전 순열 출력
        for (int x = 0; x < arr.length; x++) {
            System.out.print(arr[x] + " ");
        }
        System.out.println(); // 배열 출력 후 줄 바꿈
    }

    // 배열의 특정 범위를 뒤집는 메서드
    private static void reverse(int[] arr, int start, int end) {
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end - 1];
            arr[end - 1] = temp;
            start++;
            end--;
        }
    }
}