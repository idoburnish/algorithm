import java.io.*;
import java.util.*;

// 우수 마을
public class Main {
    static int[] info;
    static int[][] dp;
    static boolean[] visit;
    static ArrayList<ArrayList<Integer>> arr;

    public static void DFS(int cur) {
        visit[cur] = true;
        dp[cur][0] = info[cur];     // 우수 마을일 경우
        dp[cur][1] = 0;     // 우수 마을이 아닐 경우

        for (int child : arr.get(cur)) {
            if (!visit[child]) {
                DFS(child);
                dp[cur][0] += dp[child][1];
                dp[cur][1] += Math.max(dp[child][0], dp[child][1]);
            }

        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        info = new int[N+1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=1; i<=N; i++) info[i] = Integer.parseInt(st.nextToken());

        arr = new ArrayList<>();
        for (int i=0; i<=N; i++) arr.add(new ArrayList<>());

        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            arr.get(v1).add(v2);
            arr.get(v2).add(v1);
        }

        dp = new int[N+1][2];
        visit = new boolean[N+1];
        DFS(1);

        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
}
