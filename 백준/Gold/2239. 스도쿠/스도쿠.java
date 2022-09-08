import java.util.*;
import java.io.*;

// 스도쿠
public class Main {
    static int[][] arr;

    public static void DFS(int row, int col) {
        if (col == 9) {
            DFS(row+1, 0);
            return;
        }

        if (row == 9) {
            for (int i=0; i<9; i++) {
                for (int j=0; j<9; j++) System.out.print(arr[i][j]);
                System.out.println();
            }
            System.exit(0);
        }

        if (arr[row][col] == 0) {
            for (int i=1; i<=9; i++) {
                if (checkValue(row, col, i)) {
                    arr[row][col] = i;
                    DFS(row, col+1);
                }
            }
            arr[row][col] = 0;
            return;
        }

        DFS(row, col+1);
    }

    public static boolean checkValue(int row, int col, int value) {
        // 가로줄
        for (int i=0; i<9; i++) {
            if (arr[row][i] == value) return false;
        }

        // 세로줄
        for (int i=0; i<9; i++) {
            if (arr[i][col] == value) return false;
        }

        // 3 X 3 네모
        int newRow = (row / 3) * 3;
        int newCol = (col / 3) * 3;
        for (int i=newRow; i<newRow+3; i++) {
            for (int j=newCol; j<newCol+3; j++) {
                if (arr[i][j] == value) return false;
            }
        }

        return true;
    }

    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        arr = new int[9][9];
        for (int i=0; i<9; i++) {
            String str = br.readLine();
            for (int j=0; j<9; j++) arr[i][j] = Character.getNumericValue(str.charAt(j));
        }

        DFS(0, 0);
    }
}
