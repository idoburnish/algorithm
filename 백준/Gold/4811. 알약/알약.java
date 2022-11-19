import java.util.*;
import java.io.*;

// 알약
public class Main {
    public static long[] solution() {
        long[] dp = new long[31];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;

        for (int i=3; i<=30; i++) {
            long cnt = 0;
            for (int j=0; j<i; j++) {
                cnt += dp[j] * dp[i-1-j];
            }
            dp[i] = cnt;
        }

        return dp;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long[] dp = solution();
        ArrayList<Long> answer = new ArrayList<>();
        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == 0) break;
            answer.add(dp[N]);
        }

        for (long cur : answer) System.out.println(cur);
    }
}
