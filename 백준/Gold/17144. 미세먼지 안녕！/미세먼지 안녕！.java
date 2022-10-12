import java.io.*;
import java.util.*;

// 미세먼지 안녕!
public class Main {
    static int R, C, T;
    static int[][] map;
    
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};

    public static int solution(ArrayList<int[]> airs) {
        for (int i=0; i<T; i++) {
            map = spreading(airs);
            cleaning(airs);
        }
        
        int answer = 0;
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (map[i][j] > 0) answer += map[i][j];
            }
        }

        return answer;
    }
    
    public static int[][] spreading(ArrayList<int[]> airs) {
        ArrayList<int[]> dusts = new ArrayList<>();
        for (int i=0; i<R; i++) {
            for (int j=0; j<C; j++) {
                if (map[i][j] > 0) dusts.add(new int[]{i, j, map[i][j]});
            }
        }

        int[][] newMap = new int[R][C];
        for (int[] dust : dusts) {
            int cnt = 0;
            int spread = dust[2] / 5;
            for (int i=0; i<4; i++) {
                int nx = dust[0] + dx[i];
                int ny = dust[1] + dy[i];
                if (nx < 0 || ny < 0 || nx >= R || ny >= C || map[nx][ny] == -1) continue;
                newMap[nx][ny] += spread;
                cnt++;
            }
            newMap[dust[0]][dust[1]] += map[dust[0]][dust[1]] - (cnt * spread);
        }

        for (int[] air : airs) newMap[air[0]][air[1]] = -1;
        return newMap;
    }

    public static void cleaning(ArrayList<int[]> airs) {
        for (int k=0; k<airs.size(); k++) {
            int[] air = airs.get(k);

            // 좌측
            if (k == 0) {
                for (int i=air[0]-1; i>0; i--) map[i][air[1]] = map[i-1][air[1]];
            }
            else {
                for (int i=air[0]+1; i<R-1; i++) map[i][air[1]] = map[i+1][air[1]];
            }

            // 상단
            if (k == 0) {
                for (int i=0; i<C-1; i++) map[0][i] = map[0][i+1];
            }
            else {
                for (int i=0; i<C-1; i++) map[R-1][i] = map[R-1][i+1];
            }


            // 우측
            if (k == 0) {
                for (int i=0; i<air[0]; i++) map[i][C-1] = map[i+1][C-1];
            }
            else {
                for (int i=R-1; i>air[0]; i--) map[i][C-1] = map[i-1][C-1];
            }

            // 하단
            for (int i=C-1; i>0; i--) {
                if (map[air[0]][i-1] == -1) map[air[0]][i] = 0;
                else map[air[0]][i] = map[air[0]][i-1];
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new int[R][C];
        ArrayList<int[]> airs = new ArrayList<>();
        for (int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j=0; j<C; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == -1) airs.add(new int[]{i, j});
            }
        }

        System.out.println(solution(airs));
    }
}