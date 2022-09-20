import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = 0, sum2 = 0;
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();
        
        for (int i=0; i<queue1.length; i++) {
            sum1 += queue1[i];
            q1.offer(queue1[i]);
        }
        for (int i=0; i<queue2.length; i++) {
            sum2 += queue2[i];
            q2.offer(queue2[i]);
        }
        
        if ((sum1 + sum2) % 2 != 0) return -1;
        
        int answer = 0;
        while (sum1 != (sum1 + sum2)/2) {
            if (sum1 > sum2) {
                sum1 -= q1.peek();
                sum2 += q1.peek();
                q2.offer(q1.poll());
            }
            else {
                sum2 -= q2.peek();
                sum1 += q2.peek();
                q1.offer(q2.poll());
            }
            answer++;
            if (answer > (queue1.length + queue2.length) * 2) return -1;
        }
        
        return answer;
    }
}