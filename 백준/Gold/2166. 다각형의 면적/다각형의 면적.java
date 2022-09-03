import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        long[][] arr = new long[N+1][2];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        arr[N][0] = arr[0][0];
        arr[N][1] = arr[0][1];

        long sumA = 0, sumB = 0;
        for (int i=0; i<N; i++) {
            sumA += arr[i][0] * arr[i+1][1];
            sumB += arr[i+1][0] * arr[i][1];
        }

        String answer = String.format("%.1f", Math.abs(sumA - sumB) / 2.0);
        System.out.println(answer);

        br.close();
    }
}
