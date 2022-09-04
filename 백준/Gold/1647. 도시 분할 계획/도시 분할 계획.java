import java.util.*;
import java.io.*;

// 도시 분할 계획
class Road implements Comparable<Road> {
    int cityA, cityB, cost;

    Road(int cityA, int cityB, int cost) {
        this.cityA = cityA;
        this.cityB = cityB;
        this.cost = cost;
    }

    @Override
    public int compareTo(Road o) {
        return this.cost - o.cost;
    }
}

public class Main {
    static int[] parent;

    public static int kruskal(int N, ArrayList<Road> arr) {
        int answer = 0;
        int max = Integer.MIN_VALUE;

        parent = new int[N+1];
        for (int i=1; i<=N; i++) parent[i] = i;

        for (Road o : arr) {
            if (find(o.cityA) != find(o.cityB)) {
                union(o.cityA, o.cityB);
                answer += o.cost;
                max = Math.max(max, o.cost);
            }
        }

        answer -= max;
        return answer;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if (x != y) parent[y] = x;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        ArrayList<Road> arr = new ArrayList<>();
        for (int i=0; i<M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());
            arr.add(new Road(a, b, cost));
        }

        Collections.sort(arr);
        System.out.println(kruskal(N, arr));;
    }
}
