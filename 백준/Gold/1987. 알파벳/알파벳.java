import java.util.*;
import java.io.*;

// 알파벳
public class Main {
    static int R, C, answer = 0;
    static Character[][] arr;
    static HashSet<Character> set;
    static boolean[][] visit;

    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void DFS(int x, int y, int num) {
        answer = Math.max(answer, num);

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx < 0 || ny < 0 || nx >= R || ny >= C) continue;
            if (!set.contains(arr[nx][ny])) {
                set.add(arr[nx][ny]);
                visit[nx][ny] = true;
                DFS(nx, ny, num + 1);
                set.remove(arr[nx][ny]);
                visit[nx][ny] = false;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        arr = new Character[R][C];
        for (int i=0; i<R; i++) {
            String str = br.readLine();
            for (int j=0; j<C; j++) arr[i][j] = str.charAt(j);
        }

        set = new HashSet<>();
        set.add(arr[0][0]);

        visit = new boolean[R][C];
        visit[0][0] = true;

        DFS(0, 0, 1);
        System.out.println(answer);
    }
}
