import java.io.*;
import java.util.*;

public class Main {
    static int belt[];
    static boolean robot[];
    static int map[];
    static int n, k, length;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        length = n * 2;
        belt = new int[length * 2];
        robot = new boolean[n];

        
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < length; i++){
            belt[i] = Integer.parseInt(st.nextToken());
        }

        int count = 0;
        while(getCount() < k){
            count++;

            // 1단계
            move_belt();

            // 2단계
            move_robot();

            // 3단계
            plus_robot();
        }
        System.out.println(count);

    }
    public static void move_belt() {
        int last = belt[length - 1];
        for (int i = length - 1; i > 0; i--) {
            belt[i] = belt[i - 1];
        }
        belt[0] = last;

        for (int i = n - 1; i > 0; i--) {
            robot[i] = robot[i - 1];
        }
        robot[0] = false;
        robot[n - 1] = false; 
    }

    public static void move_robot() {
        for (int i = n - 2; i >= 0; i--) { 
            if (robot[i] && !robot[i + 1] && belt[i + 1] > 0) {
                robot[i + 1] = true;
                robot[i] = false;
                belt[i + 1]--; 
            }
        }
        robot[n - 1] = false; 
    }

    public static void plus_robot(){
        if(belt[0] >= 1){
            belt[0]--;
            robot[0] = true;
        }
    }
    public static int getCount(){
        int count  = 0;
        for(int i = 0; i < length; i++){
            if(belt[i] == 0)
                count++;
        }

        return count;
    }
}

//1. 일단 회전
//2. 회전 후 로봇은 앞으로 한칸 이동가능 만약 이동이 불가능하면 가만히
//3. 올리거나 이동하면 내구도 즉시 1 감소