import java.util.*;
import java.io.*;

// ACM Craft
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] answer = new int[T];
        for (int k=0; k<T; k++) {
            st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());   // 건물의 개수
            int K = Integer.parseInt(st.nextToken());   // 순서 규칙 개수

            int[] time = new int[N+1];
            st = new StringTokenizer(br.readLine());
            for (int i=1; i<=N; i++) time[i] = Integer.parseInt(st.nextToken());

            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for (int i=0; i<=N; i++) arr.add(new ArrayList<>());

            int[] indegree = new int[N+1];
            for (int i=0; i<K; i++) {
                st = new StringTokenizer(br.readLine());
                int before = Integer.parseInt(st.nextToken());
                int after = Integer.parseInt(st.nextToken());
                arr.get(before).add(after);
                indegree[after]++;
            }

            int last = Integer.parseInt(br.readLine());

            int[] dp = new int[N+1];
            Queue<Integer> queue = new LinkedList<>();
            for (int i=1; i<=N; i++) {
                if (indegree[i] == 0) {
                    queue.offer(i);
                    dp[i] = time[i];
                }
            }

            while (!queue.isEmpty()) {
                int cur = queue.poll();
                for (int next : arr.get(cur)) {
                    dp[next] = Math.max(dp[next], dp[cur] + time[next]);
                    indegree[next]--;
                    if (indegree[next] == 0) queue.offer(next);
                }
            }

            answer[k] = dp[last];
        }
        
        for (int result : answer) System.out.println(result);
    }
}