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
        Arrays.sort(arr);

        int min = 2000000001;
        int[] answer = new int[2];

        int left = 0, right = N-1;
        while (left < right) {
            int sum = arr[left] + arr[right];
            if (Math.abs(sum) < min) {
                min = Math.abs(sum);
                answer[0] = arr[left];
                answer[1] = arr[right];
            }
            if (sum > 0) right--;
            else left++;
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
