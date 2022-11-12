import java.io.*;
import java.util.*;

// 입국심사
public class Main {
    public static long solution(int N, int M, int[] times) {
        long answer = 0;
        long start = 1, end = (long) times[N - 1] * M;

        while (start <= end) {
            long mid = (start + end) / 2;

            long sum = 0;
            for (int time : times) sum += mid / time;
            
            if (sum >= M) {
                end = mid - 1;
                answer = mid;
            }
            else start = mid + 1;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] times = new int[N];
        for (int i=0; i<N; i++) times[i] = Integer.parseInt(br.readLine());

        Arrays.sort(times);
        System.out.println(solution(N, M, times));
    }
}
