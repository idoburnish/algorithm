import java.util.*;
import java.io.*;

// 공유기 설치
public class Main {
    public static int canInstall(int mid, int N, int[] house) {
        int before = house[0], cnt = 1;
        for (int i=1; i<N; i++) {
            if (house[i] - before >= mid) {
                before = house[i];
                cnt++;
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        int[] houses = new int[N];
        for (int i=0; i<N; i++) houses[i] = Integer.parseInt(br.readLine());
        Arrays.sort(houses);

        int left = 1, right = houses[N-1] - houses[0];
        while (left <= right) {
            int mid = (left + right) / 2;

            if (canInstall(mid, N, houses) < C)  right = mid - 1;
            else left = mid + 1;
        }
        System.out.println(left - 1);
    }
}
