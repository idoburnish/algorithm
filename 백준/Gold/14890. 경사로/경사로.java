import java.util.*;
import java.io.*;

public class Main {
    public static int N, L;
    public static int[][] map;

    public static boolean calRow(int row) {
        int diff;
        boolean[] slope = new boolean[N];

        for (int i=0; i<N-1; i++) {
            diff = map[row][i+1] - map[row][i];
            if (Math.abs(diff) > 1) return false;
            if (diff == 1) {
                if (i+1 < L) return false;
                for (int j=0; j<L; j++) {
                    if (slope[i-j]) return false;
                    if (map[row][i-j] != map[row][i+1] - diff) return false;
                    else slope[i-j] = true;
                }
            }
            else if (diff == -1) {
                if (N-i <= L) return false;
                for (int j=1; j<=L; j++) {
                    if (slope[i+j]) return false;
                    if (map[row][i+j] != map[row][i] + diff) return false;
                    else slope[i+j] = true;
                }
            }
        }

        return true;
    }

    public static boolean calCol(int col) {
        int diff;
        boolean[] slope = new boolean[N];

        for (int i=0; i<N-1; i++) {
            diff = map[i+1][col] - map[i][col];
            if (Math.abs(diff) > 1) return false;
            if (diff == 1) {
                if (i+1 < L) return false;
                for (int j=0; j<L; j++) {
                    if (slope[i-j]) return false;
                    if (map[i-j][col] != map[i+1][col] - diff) return false;
                    else slope[i-j] = true;
                }
            }
            else if (diff == -1) {
                if (N-i <= L) return false;
                for (int j=1; j<=L; j++) {
                    if (slope[i+j]) return false;
                    if (map[i+j][col] != map[i][col] + diff) return false;
                    else slope[i+j] = true;
                }
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = 0;
        for (int i=0; i<N; i++) {
            if (calRow(i)) answer++;
            if (calCol(i)) answer++;
        }

        System.out.println(answer);
    }
}