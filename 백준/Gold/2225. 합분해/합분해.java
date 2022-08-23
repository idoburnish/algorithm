import java.util.*;
import java.io.*;

// 합분해
public class Main {
    static int mod = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] dp = new int[K+1][N+1];
        for (int i=0; i<=N; i++) dp[1][i] = 1;
        for (int i=0; i<=K; i++) dp[i][0] = 1;

        for (int i=2; i<=K; i++) {
            for (int j=1; j<=N; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
                dp[i][j] %= mod;
            }
        }

        System.out.println(dp[K][N]);
    }
}
