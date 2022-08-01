import java.util.*;
import java.io.*;

class Point {
    int x, y;
    Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    static int N, L, R;
    static int A[][];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static int movePeople() {
        int sum, union = 0;
        boolean[][] check = new boolean[N][N];

        for (int i=0; i<N; i++) {
            for (int j=0; j<N; j++) {
                if (!check[i][j]) {
                    Queue<Point> queue = new LinkedList<>();
                    Point point = new Point(i, j);
                    queue.add(point);

                    ArrayList<Point> arr = new ArrayList<>();
                    arr.add(point);
                    check[i][j] = true;
                    sum = A[i][j];

                    while (!queue.isEmpty()) {
                        Point cur = queue.poll();

                        for (int k=0; k<4; k++) {
                            int nx = cur.x + dx[k];
                            int ny = cur.y + dy[k];

                            if (nx >= 0 && nx < N && ny >= 0 && ny < N) {
                                if (!check[nx][ny] && checkBoundary(cur.x, cur.y, nx, ny)) {
                                    queue.add(new Point(nx, ny));
                                    arr.add(new Point(nx, ny));
                                    check[nx][ny] = true;
                                    sum += A[nx][ny];
                                    union++;
                                }
                            }
                        }
                    }

                    if (arr.size() > 0) {
                        int aver = sum / arr.size();

                        for (int k = 0; k < arr.size(); k++) {
                            Point cur = arr.get(k);
                            A[cur.x][cur.y] = aver;
                        }
                    }
                }
            }
        }

        return union;
    }

    static boolean checkBoundary(int cx, int cy, int nx, int ny) {
        int sub = Math.abs(A[cx][cy] - A[nx][ny]);
        return sub >= L && sub <= R;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());

        A = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) A[i][j] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;
        while (movePeople() != 0)  answer++;
        System.out.println(answer);
    }
}
