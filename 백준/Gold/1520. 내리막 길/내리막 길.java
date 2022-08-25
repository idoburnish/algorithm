import java.util.*;
import java.io.*;

// 내리막 길
public class Main {
    static int M, N;
    static int[][] map, dp;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static int DFS(int x, int y) {
        if (x == M-1 && y == N-1) return 1;
        if (dp[x][y] != -1) return dp[x][y];

        dp[x][y] = 0;
        for (int i=0; i<4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= M || ny >= N) continue;
            if (map[x][y] > map[nx][ny]) {
                dp[x][y] += DFS(nx, ny);
            }
        }
        return dp[x][y];
    }
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());   // 세로
        N = Integer.parseInt(st.nextToken());   // 가로

        map = new int[M][N];
        dp = new int[M][N];
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                dp[i][j] = -1;
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(DFS(0, 0));
    }
}