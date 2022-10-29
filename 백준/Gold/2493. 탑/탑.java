import java.util.*;
import java.io.*;

// 탑
public class Main {
    public static int[] solution(int N, int[] tops) {
        int[] answer = new int[N];

        Stack<int[]> stack = new Stack<>();
        for (int i=0; i<N; i++) {
            while (!stack.isEmpty()) {
                if (stack.peek()[1] < tops[i]) stack.pop();
                else {
                    answer[i] = stack.peek()[0];
                    break;
                }
            }
            if (stack.isEmpty()) answer[i] = 0;
            stack.push(new int[]{i+1, tops[i]});
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] tops = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) tops[i] = Integer.parseInt(st.nextToken());

        int[] answer = solution(N, tops);
        for (int cur : answer) System.out.print(cur + " ");
    }
}
