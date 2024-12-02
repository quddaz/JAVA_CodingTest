import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.io.IOException;

public class Main {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Integer.parseInt(br.readLine());

        long s = 3;
        int n = 0;

        while(s < N){
            n++;
            s = s * 2 + (3 + n);
        }

        System.out.println(func(N, n, s));
    }

    public static char func(long N, int n, long s) {
        if(n == 0){
            return N == 1 ? 'm' : 'o';
        }
        long prev = (s - (3 + n)) / 2; //S(N-1)의 길이
        if(N <= prev) //만약 N보다 길이가 길다면 첫번째 구역
            return func(N, n-1, prev);
        else if(N > prev + (3 + n)) // 만약 N이 S(N-1)길이 + 중간 길이보다 크다면 다음 구역
            return func(N - prev - (3 + n), n-1, prev);
        else //만약 중앙값이라면
            return (N - prev == 1) ? 'm' : 'o';
    }
}