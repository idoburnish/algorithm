import java.util.*;
import java.io.*;

// 정보 상인 호석
public class Main {
    public static long answer = 0;
    public static HashMap<String, PriorityQueue<Integer>> map = new HashMap<>();

    public static void info(String name, int[] value) {
        PriorityQueue<Integer> pqueue = map.getOrDefault(name, new PriorityQueue<>(Collections.reverseOrder()));
        for (int v : value) pqueue.offer(v);
        map.put(name, pqueue);
    }

    public static void buy(String name, int cnt) {
//        if (map.get(name) == null) return;
//        while (!map.get(name).isEmpty() && cnt > 0) {
//            answer += map.get(name).poll();
//            cnt--;
//        }

        PriorityQueue<Integer> pqueue = map.getOrDefault(name, new PriorityQueue<>(Collections.reverseOrder()));
        for (int i=0; i<cnt; i++) {
            if (pqueue.isEmpty()) break;
            answer += pqueue.poll();
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            int cnt = Integer.parseInt(st.nextToken());

            if (type == 1) {
                int[] value = new int[cnt];
                for (int k=0; k<cnt; k++) value[k] = Integer.parseInt(st.nextToken());
                info(name, value);
            }
            else {
                buy(name, cnt);
            }
        }
        System.out.println(answer);
    }
}
