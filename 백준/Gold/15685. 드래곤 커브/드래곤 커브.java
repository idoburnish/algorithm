import java.io.*;
import java.util.*;

// 드래곤 커브
public class Main {
    static boolean[][] map = new boolean[101][101];

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static void dragonCurve(int x, int y, int d, int g) {
        ArrayList<Integer> direction = new ArrayList<>();
        direction.add(d);

        for (int i=1; i<=g; i++) {
            int len = direction.size();
            for (int j=len-1; j>=0; j--) direction.add((direction.get(j) + 1) % 4);
        }

        for (int next : direction) {
            map[x][y] = true;
            x += dx[next];
            y += dy[next];
        }
        map[x][y] = true;
    }

    public static int countRectangle() {
        int answer = 0;
        for (int i=0; i<100; i++) {
            for (int j=0; j<100; j++) {
                if (check(i, j)) answer++;
            }
        }
        return answer;
    }

    public static boolean check(int x, int y) {
        if (!map[x][y]) return false;
        if (!map[x+1][y]) return false;
        if (!map[x][y+1]) return false;
        if (!map[x+1][y+1]) return false;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            dragonCurve(x, y, d, g);
        }

        System.out.println(countRectangle());
    }
}