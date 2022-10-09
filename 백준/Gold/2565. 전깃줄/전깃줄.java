import java.io.*;
import java.util.*;

// 전깃줄
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] arr = new int[N][2];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        int answer = 0;
        int[] dp = new int[N];
        for (int i=0; i<N; i++) {
            dp[i] = 1;
            for (int j=0; j<i; j++) {
                if (arr[i][1] > arr[j][1]) dp[i] = Math.max(dp[i], dp[j]+1);
            }
        }
        
        int max = 0;
        for (int i=0; i<N; i++) max = Math.max(max, dp[i]);
        System.out.println(N - max);
    }
}
