import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        int[] arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int sum = 0, minLength = Integer.MAX_VALUE;
        int start = 0, end = 0;

        while (start <= N && end <= N) {
            if (sum >= S && minLength > end - start) minLength = end - start;
            if (sum < S) sum += arr[end++];
            else sum -= arr[start++];
        }

        if (minLength == Integer.MAX_VALUE) System.out.println(0);
        else System.out.println(minLength);
    }
}
