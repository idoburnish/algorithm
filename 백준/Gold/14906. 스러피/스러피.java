import java.util.*;
import java.io.*;

// 스러피
public class Main {
    public static boolean isSlimp(String s) {
        if (s.length() < 2) {
            return false;
        }

        if (s.length() == 2 && s.equals("AH")) {
            return true;
        }

        if (s.charAt(0) == 'A' && s.charAt(s.length() - 1) == 'C') {
            if (s.charAt(1) == 'B') {
                return isSlimp(s.substring(2, s.length() - 1));
            } else {
                return isSlump(s.substring(1, s.length() - 1));
            }
        }

        return false;
    }

    public static boolean isSlump(String s) {
        return s.matches("^([DE]F+)+G$");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        String[] answer = new String[N];
        for (int i=0; i<N; i++) {
            String str = br.readLine();
            int lastIdxOfC = str.lastIndexOf('C');

            if (lastIdxOfC != -1) {
                if (isSlimp(str.substring(0, lastIdxOfC + 1)) && isSlump(str.substring(lastIdxOfC + 1))) {
                    answer[i] = "YES";
                } else {
                    answer[i] = "NO";
                }
            }
            else {
                if (str.startsWith("AH") && isSlump(str.substring(2))) {
                    answer[i] = "YES";
                } else {
                    answer[i] = "NO";
                }
            }
        }

        System.out.println("SLURPYS OUTPUT");
        for (String str : answer) System.out.println(str);
        System.out.println("END OF OUTPUT");
    }
}
