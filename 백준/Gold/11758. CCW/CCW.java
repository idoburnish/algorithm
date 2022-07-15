import java.util.*;
import java.io.*;

// CCW (Counter Clockwise)
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        int[][] point = new int[3][2];
        for (int i=0; i<3; i++) {
            st = new StringTokenizer(br.readLine());
            point[i][0] = Integer.parseInt(st.nextToken());
            point[i][1] = Integer.parseInt(st.nextToken());
        }

        int[][] vector = new int[2][2];
        vector[0][0] = point[1][0] - point[0][0];
        vector[0][1] = point[1][1] - point[0][1];
        vector[1][0] = point[2][0] - point[0][0];
        vector[1][1] = point[2][1] - point[0][1];

        int ccw = vector[0][0] * vector[1][1] - vector[0][1] * vector[1][0];
        if (ccw > 0) System.out.println(1);
        else if (ccw < 0) System.out.println(-1);
        else System.out.println(0);
    }
}
