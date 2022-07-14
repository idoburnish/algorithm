import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] indegree = new int[N+1];
        ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
        for (int i=0; i<=N; i++) arr.add(new ArrayList<>());

        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            arr.get(from).add(to);
            indegree[to]++;
        }

        PriorityQueue<int[]> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        for (int i=1; i<=N; i++) {
            if (indegree[i] == 0) queue.offer(new int[] {i, indegree[i]});
        }

        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            System.out.print(cur[0] + " ");

            for (Integer x : arr.get(cur[0])) {
                indegree[x]--;
                if (indegree[x] == 0) queue.offer(new int[] {x, indegree[x]});
            }

        }
    }
}