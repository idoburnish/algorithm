import java.io.*;
import java.util.*;

// 톱니바퀴
public class Main {
    public static String[] solution(String[] str, int num, int direction) {
        int[] direct = new int[5];
        direct[num] = direction;

        for (int i=num; i<4; i++) {
            if (str[i].charAt(2) != str[i+1].charAt(6)) {
                direct[i+1] = -direct[i];
            }
            else break;
        }
        for (int i=num; i>1; i--) {
            if (str[i].charAt(6) != str[i-1].charAt(2)) {
                direct[i-1] = -direct[i];
            }
            else break;
        }

        for (int i=1; i<5; i++) {
            str[i] = rotate(str[i], direct[i]);
        }
        return str;
    }

    public static String rotate(String str, int direction) {
        if (direction == 1) {
            String temp = str.substring(7);
            return temp + str.substring(0, 7);
        }
        else if (direction == -1) {
            String temp = str.substring(0, 1);
            return str.substring(1, 8) + temp;
        }
        else {
            return str;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str = new String[5];
        for (int i=1; i<=4; i++) str[i] = br.readLine();

        StringTokenizer st;
        int K = Integer.parseInt(br.readLine());
        for (int i=0; i<K; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int direction = Integer.parseInt(st.nextToken());
            str = solution(str, num, direction);
        }

        int answer = 0;
        for (int i=1; i<=4; i++) {
            if (str[i].charAt(0) == '1') answer += Math.pow(2, i-1);
        }
        System.out.println(answer);
    }
}