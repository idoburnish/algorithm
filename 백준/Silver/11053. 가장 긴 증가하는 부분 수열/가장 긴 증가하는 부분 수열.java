import java.io.*;
import java.util.*;

// 가장 긴 증가하는 부분 수열
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N];
        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int answer = 0;
        for (int i=0; i<N; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if (arr[j] < arr[i]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
            answer = Math.max(dp[i], answer);
        }
        System.out.println(answer);
    }
}
