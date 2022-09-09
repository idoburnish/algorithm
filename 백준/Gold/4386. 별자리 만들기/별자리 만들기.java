import java.util.*;
import java.io.*;

// 별자리 만들기
class Point {
    int idx;
    double x, y;

    Point (int idx, double x, double y) {
        this.idx = idx;
        this.x = x;
        this.y = y;
    }
}

class Node implements Comparable<Node> {
    Point a, b;
    double dist;

    Node (Point a, Point b) {
        this.a = a;
        this.b = b;
        this.dist = Math.sqrt(Math.pow(a.x - b.x, 2) + Math.pow(a.y - b.y, 2));
    }

    @Override
    public int compareTo(Node o) {
        return Double.compare(this.dist, o.dist);
    }
}

public class Main {
    static int[] parent;

    public static double solution(int N, ArrayList<Node> arr) {
        double answer = 0;

        parent = new int[N];
        for (int i=0; i<N; i++) parent[i] = i;

        for (Node o : arr) {
            if (find(o.a.idx) != find(o.b.idx)) {
                union(o.a.idx, o.b.idx);
                answer += o.dist;
            }
        }

        return answer;
    }

    public static void union(int a, int b) {
        a = find(a);
        b = find(b);
        if (a != b) parent[a] = b;
    }

    public static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        Point[] point = new Point[N];
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            double x = Double.parseDouble(st.nextToken());
            double y = Double.parseDouble(st.nextToken());
            point[i] = new Point(i, x, y);
        }

        ArrayList<Node> arr = new ArrayList<>();
        for (int i=0; i<N; i++) {
            for (int j=i+1; j<N; j++) {
                arr.add(new Node(point[i], point[j]));
            }
        }

        Collections.sort(arr);
        System.out.printf("%.2f%n", solution(N, arr));
    }
}