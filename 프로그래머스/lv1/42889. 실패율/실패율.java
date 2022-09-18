import java.util.*;

class Stage implements Comparable<Stage> {
    public int num, success, access;
    public double failRate;
    
    Stage (int num) {
        this.num = num;
        this.success = 0;
        this.access = 0;
    }
    
    public void calFailRate() {
        if (this.access == 0) this.failRate = 0;
        else this.failRate = this.access / (double) this.success; 
    }
    
    @Override
    public int compareTo(Stage o) {
        return Double.compare(o.failRate, this.failRate);
    }
}

class Solution {
    public int[] solution(int N, int[] stages) {      
        ArrayList<Stage> arr = new ArrayList<>();
        for (int i=0; i<=N+1; i++) arr.add(new Stage(i));
        
        for (int stage : stages) {
            for (int i=1; i<=stage; i++) arr.get(i).success++;
            arr.get(stage).access++;
        }
        
        arr.remove(0);
        arr.remove(arr.size()-1);
        for (int i=0; i<N; i++) arr.get(i).calFailRate();
        Collections.sort(arr);
        
        int[] answer = new int[N];
        for (int i=0; i<N; i++) {
            answer[i] = arr.get(i).num;
        }
        
        return answer;
    }
}