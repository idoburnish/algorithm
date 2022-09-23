import java.util.*;
import java.io.*;

class Node implements Comparable<Node> {
    public int num, time;

    Node (int num) {
        this.num = num;
        this.time = 0;
    }

    @Override
    public int compareTo (Node o) {
        return o.time - this.time;
    }
}

public class Main {
    static ArrayList<ArrayList<Node>> arr;

    public static int DFS(int cur) {
        int max=0, p=0;

        for(Node i : arr.get(cur)){
            i.time = DFS(i.num);
        }

        Collections.sort(arr.get(cur));
        for(Node next : arr.get(cur)){
            p++;
            max=Math.max(max, next.time + p);
        }
        return max;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        for (int i=0; i<N; i++) arr.add(new ArrayList<>());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i=0; i<N; i++) {
            int boss = Integer.parseInt(st.nextToken());
            if (boss == -1) continue;
            arr.get(boss).add(new Node(i));
        }

        System.out.println(DFS(0));
    }
}