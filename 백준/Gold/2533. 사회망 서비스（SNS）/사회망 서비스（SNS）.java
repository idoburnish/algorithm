import java.util.*;
import java.io.*;

// 사회망 서비스(SNS)
public class Main {
    public static int[][] dp;
    public static boolean[] visit;
    public static ArrayList<ArrayList<Integer>> arr;

    public static void DFS(int num) {
        visit[num] = true;
        dp[num][0] = 0;     // 해당 num 사람이 얼리어답터가 아닌 경우
        dp[num][1] = 1;     // 해당 num 사람이 얼리어답터인 경우 (개수 1)

        for (int child : arr.get(num)) {
            if (!visit[child]) {
                DFS(child);
                dp[num][0] += dp[child][1]; // 자식 노드가 무조건 얼리어답터
                dp[num][1] += Math.min(dp[child][0], dp[child][1]);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        for (int i=0; i<=N; i++) arr.add(new ArrayList<>());

        StringTokenizer st;
        for (int i=0; i<N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }

        dp = new int[N+1][2];
        visit = new boolean[N+1];
        DFS(1);

        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
}
