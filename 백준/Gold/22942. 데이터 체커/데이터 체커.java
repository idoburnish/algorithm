import java.io.*;
import java.util.*;

// 데이터 체커
public class Main {
    static boolean solution(int N, int[][] arr) {
        int[] prev = new int[] {Integer.MIN_VALUE, Integer.MIN_VALUE};

        for (int[] cur : arr) {
            if (prev[1] >= cur[0] && prev[1] <= cur[1]) return false;
            prev = cur;
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[][] arr = new int[N][2];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int r = Integer.parseInt(st.nextToken());
            arr[i][0] = x-r;
            arr[i][1] = x+r;
        }

        Arrays.sort(arr, (o1, o2) -> {
            if (o1[0] == o2[0]) return o1[1] - o2[1];
            return o1[0] - o2[0];
        });

        if (solution(N, arr)) System.out.println("YES");
        else System.out.println("NO");
    }
}
