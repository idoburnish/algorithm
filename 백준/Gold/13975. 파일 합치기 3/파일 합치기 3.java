import java.util.*;
import java.io.*;

// 파일 합치기 3
public class Main {
    public static long solution(int K, int[] arr) {
        PriorityQueue<Long> pqueue = new PriorityQueue<>();
        for (int i=0; i<K; i++) pqueue.offer((long) arr[i]);

        long answer = 0;
        while (pqueue.size() > 1) {
            long newFile = pqueue.poll() + pqueue.poll();
            pqueue.offer(newFile);
            answer += newFile;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        long[] answer = new long[T];
        for (int k=0; k<T; k++) {
            int K = Integer.parseInt(br.readLine());

            int[] arr = new int[K];
            st = new StringTokenizer(br.readLine());
            for (int i=0; i<K; i++) arr[i] = Integer.parseInt(st.nextToken());

            answer[k] = solution(K, arr);
        }

        for (long result : answer) System.out.println(result);
    }
}
