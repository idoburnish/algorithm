import java.util.*;
import java.io.*;

public class Main {
    public static int solution(int[][] arr) {
        int answer = 0;

        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
        int day = arr[0][0];

        int cnt = 0;
        for (int i=day; i>0; i--) {
            while (cnt < arr.length && arr[cnt][0] == i) {
                pqueue.offer(arr[cnt][1]);
                cnt++;
            }
            if (!pqueue.isEmpty()) answer += pqueue.poll();
        }

        return answer;
    }

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
            if (o1[0] == o2[0]) return o2[1] - o1[1];
            return o2[0] - o1[0];
        });

        System.out.println(solution(arr));
    }
}