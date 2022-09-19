import java.util.*;

class Solution {
    public boolean solution(int[][] key, int[][] lock) {  
        int N = lock.length;
        int M = key.length;
        
        int[][] map = new int[N + 2*M - 2][N + 2*M - 2];
        for (int i=M-1; i<M+N-1; i++) {
            for (int j=M-1; j<M+N-1; j++) map[i][j] = lock[i-M+1][j-M+1];
        }

        for (int k=0; k<4; k++) {
            key = rotation(M, key);
            if (check(key, map, N)) return true;
        }
        
        return false;
    }

    public int[][] rotation(int M, int[][] key) {
        int[][] newKey = new int[M][M];
        
        for (int i=0; i<M; i++) {
            for (int j=0; j<M; j++) newKey[j][M-i-1] = key[i][j];
        }
        
        return newKey;
    }
    
    public boolean check(int[][] key, int[][] map, int lockLen) {
        int keyLen = key.length;
        int mapLen = map.length;
        
        for (int i=0; i<mapLen - keyLen + 1; i++) {
            for (int j=0; j<mapLen - keyLen + 1; j++) {
                // 키 채우기
                for (int k=0; k<keyLen; k++) {
                    for (int l=0; l<keyLen; l++) map[i+k][j+l] += key[k][l];
                }
                
                // 자물쇠 확인
                boolean flag = true;
                for (int k=keyLen-1; k<keyLen-1 + lockLen; k++) {
                    for (int l=keyLen-1; l<keyLen-1 + lockLen; l++) {
                        if (map[k][l] != 1) flag = false;
                    }
                }
                if (flag) return true;
                
                // 키 해제
                for (int k=0; k<keyLen; k++) {
                    for (int l=0; l<keyLen; l++) map[i+k][j+l] -= key[k][l];
                }
            }
        }
        
        return false;
    }
}