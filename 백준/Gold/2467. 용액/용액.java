import java.util.*;
import java.io.*;

// 두 용액
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) arr[i] = Integer.parseInt(st.nextToken());

        int diff = Integer.MAX_VALUE;
        int[] idx = new int[2];
        int left = 0, right = N-1;

        while (left < right) {
            int sum = arr[left] + arr[right];

            if (Math.abs(sum) <= diff) {
                diff = Math.abs(sum);
                idx[0] = left;
                idx[1] = right;
            }

            if (sum > 0) right--;
            else left++;
        }

        System.out.println(arr[idx[0]] + " " + arr[idx[1]]);
    }
}
