import java.util.*;

class Solution {
    public int[] dx1 = {-2, 0, 2, 0};
    public int[] dy1 = {0, -2, 0, 2};
    public int[] dx2 = {1, 1, -1, -1};
    public int[] dy2 = {1, -1, 1, -1};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        int idx = 0;
        for (String[] str : places) {
            char[][] map = new char[5][5];
            for (int i=0; i<5; i++) {
                for (int j=0; j<5; j++) map[i][j] = str[i].charAt(j);
            }
            
            boolean result = distancing(map);
            if (result) answer[idx] = 1;
            else answer[idx] = 0;
            idx++;
        }
        
        return answer;
    }
    
    public boolean distancing(char[][] map) {
        for (int i=0; i<5; i++) {
            for (int j=0; j<5; j++) {
                if (map[i][j] == 'P') {
                    for (int k=0; k<4; k++) {
                        int nx = i + dx1[k]/2;
                        int ny = j + dy1[k]/2;
                        if (nx < 0 || nx > 4 || ny < 0 || ny > 4) continue;
                        if (map[nx][ny] == 'P') return false;
                    }
                    for (int k=0; k<4; k++) {
                        int nx = i + dx1[k];
                        int ny = j + dy1[k];
                        if (nx < 0 || nx > 4 || ny < 0 || ny > 4) continue;
                        if (map[nx][ny] == 'P' && map[(i+nx)/2][(j+ny)/2] == 'O') return false;
                    }
                    for (int k=0; k<4; k++) {
                        int nx = i + dx2[k];
                        int ny = j + dy2[k];
                        if (nx < 0 || nx > 4 || ny < 0 || ny > 4) continue;
                        if (map[nx][ny] == 'P' && (map[nx][j] != 'X' || map[i][ny] != 'X')) return false;
                    }
                }
            }
        }
        return true;
    }
}