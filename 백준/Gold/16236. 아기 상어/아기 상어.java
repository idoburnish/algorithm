import java.util.*;
import java.io.*;

public class Main {
    static int[] dx = {-1, 0, 0, 1};
    static int[] dy = {0, -1, 1, 0};
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        map = new int[N][N];
        int[] cur = null;

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 9) {
                    cur = new int[] {i, j};
                    map[i][j] = 0;
                }
            }
        }

        int eat = 0;
        int shark = 2;
        int answer = 0;

        while (true) {
            PriorityQueue<int[]> pqueue = new PriorityQueue<>((o1, o2) ->
                    o1[2] != o2[2] ? Integer.compare(o1[2], o2[2]) : (o1[0] != o2[0] ? Integer.compare(o1[0], o2[0]) : Integer.compare(o1[1], o2[1]))
            );
            boolean[][] visit = new boolean[N][N];

            pqueue.add(new int[] {cur[0], cur[1], 0});
            visit[cur[0]][cur[1]] = true;
            boolean check = false;

            while (!pqueue.isEmpty()) {
                cur = pqueue.poll();
                if (map[cur[0]][cur[1]] != 0 && map[cur[0]][cur[1]] < shark) {
                    eat++;
                    map[cur[0]][cur[1]] = 0;
                    answer += cur[2];
                    check = true;
                    break;
                }

                for (int i=0; i<4; i++) {
                    int nx = cur[0] + dx[i];
                    int ny = cur[1] + dy[i];
                    if (nx < 0 || ny < 0 || nx >= N || ny >= N || visit[nx][ny] || map[nx][ny] > shark) continue;
                    pqueue.add(new int[] {nx, ny, cur[2] + 1});
                    visit[nx][ny] = true;
                }
            }

            if (!check) break;
            if (shark == eat) {
                shark++;
                eat = 0;
            }
        }
        System.out.println(answer);
    }
}
