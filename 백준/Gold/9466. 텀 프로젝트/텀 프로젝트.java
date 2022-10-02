import java.io.*;
import java.util.*;

// 텀 프로젝트
class Main {
    static int count;
    static int[] arr;
    static boolean[] visit;
    static boolean[] searchEnd;

    public static int solution(int n) {
        visit = new boolean[n+1];
        searchEnd = new boolean[n+1];

        count = 0;
        for (int i=1; i<=n; i++) DFS(i);

        return n - count;
    }

    public static void DFS(int cur) {
        visit[cur] = true;
        int next = arr[cur];

        if (!visit[next]) DFS(next);
        else {
            if (!searchEnd[next]) {
                count++;
                while (next != cur) {
                    count++;
                    next = arr[next];
                }
            }
        }
        searchEnd[cur] = true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] answer = new int[T];
        for (int k=0; k<T; k++) {
            int n = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine());

            arr = new int[n+1];
            for (int i=1; i<=n; i++) arr[i] = Integer.parseInt(st.nextToken());

            answer[k] = solution(n);
        }

        for (int result : answer) System.out.println(result);
    }
}
