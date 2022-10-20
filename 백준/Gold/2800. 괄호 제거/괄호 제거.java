import java.util.*;
import java.io.*;

// 괄호 제거
public class Main {
    static TreeSet<String> answer = new TreeSet<>();
    static ArrayList<int[]> pair;
    static boolean[] check;

    public static ArrayList<int[]> getPair(String str) {
        ArrayList<int[]> pair = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();

        for (int i=0; i<str.length(); i++) {
            if (str.charAt(i) == '(') stack.push(i);
            if (str.charAt(i) == ')') pair.add(new int[]{stack.pop(), i});
        }

        return pair;
    }

    public static void DFS(int cur, String str) {
        if (cur == pair.size()) getStr(str);
        else {
            check[cur] = true;
            DFS(cur+1, str);
            check[cur] = false;
            DFS(cur+1, str);
        }
    }

    public static void getStr(String str) {
        StringBuilder sb = new StringBuilder(str);

        int cnt = 0;
        for (int i=0; i<pair.size(); i++) {
            if (check[i]) {
                sb.setCharAt(pair.get(i)[0], ' ');
                sb.setCharAt(pair.get(i)[1], ' ');
                cnt++;
            }
        }

        if (cnt == 0) return;
        String newStr = sb.toString().replaceAll("\\s", "");
        answer.add(newStr);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        pair = getPair(str);
        check = new boolean[pair.size()];
        DFS(0, str);

        for (String result : answer) System.out.println(result);
    }
}
