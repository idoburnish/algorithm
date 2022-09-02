import java.util.*;
import java.io.*;

// 순회공연
public class Main {
    public static int solution(int[][] arr) {
        if (arr.length == 0) return 0;
        
        int answer = 0;

        int day = arr[0][1], idx = 0;
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());

        for (int i=day; i>0; i--) {
            while (idx < arr.length && arr[idx][1] == i) {
                pqueue.offer(arr[idx][0]);
                idx++;
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

        Arrays.sort(arr, (o1, o2) -> o2[1] - o1[1]);

        System.out.println(solution(arr));
    }
}
