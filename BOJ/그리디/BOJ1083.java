import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        List<Integer> A = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            A.add(sc.nextInt());
        }
        int S = sc.nextInt();

        for (int i = 0; i < N && S > 0; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < N && j - i <= S; j++) {
                if (A.get(j) > A.get(maxIdx)) {
                    maxIdx = j;
                }
            }

            for (int j = maxIdx; j > i; j--) {
                Collections.swap(A, j, j - 1);
            }

            S -= (maxIdx - i);
        }

        for (int num : A) {
            System.out.print(num + " ");
        }
    }
}
