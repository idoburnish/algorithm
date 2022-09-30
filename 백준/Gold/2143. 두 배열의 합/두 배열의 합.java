import java.util.*;
import java.io.*;

// 두 배열의 합
public class Main {
    static ArrayList<Integer> sumA = new ArrayList<>();
    static ArrayList<Integer> sumB = new ArrayList<>();

    static long getCount(int T) {
        long answer = 0;

        int pA = 0, pB = sumB.size()-1;
        while (pA < sumA.size() && pB >= 0) {
            long sum = sumA.get(pA) + sumB.get(pB);

            if (sum == T) {
                int curA = sumA.get(pA);
                int curB = sumB.get(pB);
                long cntA = 0, cntB = 0;

                while (pA < sumA.size() && sumA.get(pA) == curA) {
                    cntA++;
                    pA++;
                }
                while (pB >= 0 && sumB.get(pB) == curB) {
                    cntB++;
                    pB--;
                }
                answer += cntA * cntB;
            }
            else if (sum < T) pA++;
            else pB--;
        }
        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<n; i++) A[i] = Integer.parseInt(st.nextToken());

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i=0; i<m; i++) B[i] = Integer.parseInt(st.nextToken());

        for (int i=0; i<n; i++) {
            int sum = 0;
            for (int j=i; j<n; j++) {
                sum += A[j];
                sumA.add(sum);
            }
        }

        for (int i=0; i<m; i++) {
            int sum = 0;
            for (int j=i; j<m; j++) {
                sum += B[j];
                sumB.add(sum);
            }
        }

        Collections.sort(sumA);
        Collections.sort(sumB);
        System.out.println(getCount(T));
    }
}