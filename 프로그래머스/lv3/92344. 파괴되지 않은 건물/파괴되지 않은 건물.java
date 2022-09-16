import java.util.*;

class Solution {
    public int solution(int[][] board, int[][] skill) {
        int answer = 0;
        
        int weight = 0;
        int[][] sum = new int[board.length+1][board[0].length+1];
        for (int[] s : skill) {
            if (s[0] == 1) weight = -s[5];
            else weight = s[5];
            
            sum[s[1]][s[2]] += weight;
            sum[s[1]][s[4]+1] -= weight;
            sum[s[3]+1][s[2]] -= weight;
            sum[s[3]+1][s[4]+1] += weight;
        }
        
        for (int i=1; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) sum[i][j] += sum[i-1][j];
        }
        
        for (int i=0; i<board.length; i++) {
            for (int j=1; j<board[0].length; j++) sum[i][j] += sum[i][j-1];
        }
        
        for (int i=0; i<board.length; i++) {
            for (int j=0; j<board[0].length; j++) {
                if (board[i][j] + sum[i][j] > 0) answer++;
            }
        }
        
        return answer;
    }
}