import java.util.*;
import java.io.*;

// Count Circle Groups
public class Main {
    static int[] parent;
    static int[][] arr;

    public static int circleGroups(int N){
        parent = new int[N];
        for (int i=0; i<N; i++) parent[i] = i;

        for (int i=0; i<N; i++) {
            for (int j=0; j<i; j++) {
                double diff = Math.sqrt(Math.pow(arr[i][0] - arr[j][0], 2) + Math.pow(arr[i][1] - arr[j][1], 2));
                if (diff <= arr[i][2] + arr[j][2]) {
                    if (findParent(i) != findParent(j)) {
                        union(i, j);
                    }
                }
            }
        }

        Set<Integer> set = new HashSet<>();
        for (int i=0; i<N; i++) {
            set.add(findParent(parent[i]));
        }

        return set.size();
    }

    public static void union(int a, int b){
        a = findParent(a);
        b = findParent(b);
        if (a != b) parent[b] = a;
    }

    public static int findParent(int cur) {
        if (cur == parent[cur]) return cur;
        return parent[cur] = findParent(parent[cur]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        int[] answer = new int[T];
        for (int i=0; i<T; i++) {
            int N = Integer.parseInt(br.readLine());
            arr = new int[N][3];

            for (int j=0; j<N; j++) {
                st = new StringTokenizer(br.readLine());
                arr[j][0] = Integer.parseInt(st.nextToken());
                arr[j][1] = Integer.parseInt(st.nextToken());
                arr[j][2] = Integer.parseInt(st.nextToken());
            }

            answer[i] = circleGroups(N);
        }

        for (int i=0; i<T; i++) System.out.println(answer[i]);
    }
}
