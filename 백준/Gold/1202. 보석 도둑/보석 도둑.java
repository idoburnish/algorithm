import java.io.*;
import java.util.*;

// 보석 도둑
class Jewel implements Comparable<Jewel> {
    int m, v;

    Jewel(int m, int v) {
        this.m = m;
        this.v = v;
    }

    @Override
    public int compareTo(Jewel o) {
        if (this.m == o.m) return this.v - o.v;
        return this.m - o.m;
    }
}
public class Main {
    public static long solution(int N, ArrayList<Jewel> jewels, ArrayList<Integer> bag) {
        long answer = 0;

        int idx = 0;
        PriorityQueue<Integer> pqueue = new PriorityQueue<>(Collections.reverseOrder());
        for (Integer integer : bag) {
            while (idx < jewels.size() && jewels.get(idx).m <= integer) {
                pqueue.offer(jewels.get(idx++).v);
            }

            if (!pqueue.isEmpty()) answer += pqueue.poll();
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Jewel> jewels = new ArrayList<>();
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int m = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            jewels.add(new Jewel(m, v));
        }

        ArrayList<Integer> bag = new ArrayList<>();
        for (int i=0; i<K; i++) bag.add(Integer.parseInt(br.readLine()));

        Collections.sort(jewels);
        Collections.sort(bag);
        System.out.println(solution(N, jewels, bag));
    }
}
