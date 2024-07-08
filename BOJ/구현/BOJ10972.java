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
        while (i >= 0 && arr[i] >= arr[i + 1]) {
            i--;
        }

        // 만약 가장 큰 순열이면 -1 출력
        if (i < 0) {
            System.out.println(-1);
            return;
        }

        // arr[i]보다 큰 가장 작은 수 찾기
        int j = arr.length - 1;
        while (arr[j] <= arr[i]) {
            j--;
        }

        // arr[i]와 arr[j]를 교환
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

        // arr[i+1]부터 arr[n-1]까지의 순서 뒤집기
        Arrays.sort(arr, i + 1, arr.length);

        // 다음 순열 출력
        for (int x = 0; x < arr.length; x++) {
            System.out.print(arr[x] + " ");
        }
        System.out.println(); 
    }
}

