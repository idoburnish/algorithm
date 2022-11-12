import java.io.*;
import java.util.*;

// 앱
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] memories = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            memories[i] = Integer.parseInt(st.nextToken());
        }

        int[] costs = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            costs[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[10001];
        Arrays.fill(dp, -1);

        for (int i=0; i<N; i++) {
            int cost = costs[i];
            for (int j=10000; j>=cost; j--) {
                if (dp[j-cost] != -1) {
                    dp[j] = Math.max(dp[j], dp[j-cost] + memories[i]);
                }
            }
            dp[cost] = Math.max(dp[cost], memories[i]);
        }

        for (int i=0; i<10001; i++) {
            if (dp[i] >= M) {
                System.out.println(i);
                break;
            }
        }
    }
}