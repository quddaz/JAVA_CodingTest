import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        char[][] rect = new char[n][m];
        for (int i = 0; i < n; i++) {
            rect[i] = br.readLine().toCharArray();
        }
        int maxSquareSize = 1;

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                for(int k = 1; k <= Math.min(n-i, m-j); k++){
                    if(rect[i][j] == rect[i][j+k-1]&& rect[i][j] == rect[i+k-1][j]&& rect[i][j] == rect[i+k-1][j+k-1]){
                        maxSquareSize = Math.max(maxSquareSize, k*k);
                    }
                }
            }
        }

        // 결과 출력
        System.out.println(maxSquareSize);
    }
}

/*
N×M크기의 직사각형이 있다. 각 칸에는 한 자리 숫자가 적혀 있다.
이 직사각형에서 꼭짓점에 쓰여 있는 수가 모두 같은 가장 큰 정사각형을 찾는 프로그램을 작성하시오.
이때, 정사각형은 행 또는 열에 평행해야 한다.
 */