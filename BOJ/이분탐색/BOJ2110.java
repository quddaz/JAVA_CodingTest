import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

import javax.lang.model.element.QualifiedNameable;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int house[] = new int[n];
        for(int i = 0; i < n; i++){
            house[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(house);
        int left = 1;
        int right = house[n - 1] - house[0];
        int answer = 0;

        while(left <= right){
            int mid = (left + right) / 2;

            if(isVaild(house, m, mid)){
                answer = mid;
                left = mid + 1;
            }else{
                right = mid - 1;
            }
        }
        System.out.println(answer);
    }

    public static boolean isVaild(int house[], int m, int mid){
        int count = 1;
        int lastInstalled = house[0];

        for (int i = 1; i < house.length; i++) {
            if (house[i] - lastInstalled >= mid) {
                count++;
                lastInstalled = house[i];
            }
        }

        return count >= m;
    }

}
