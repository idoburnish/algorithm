import java.util.*;

class Solution {
    public int[] solution(String[] gems) {
        int[] answer = new int[2];
        
        HashSet<String> set = new HashSet<>();
        for (String str : gems) set.add(str);
        
        int len = gems.length;
        int start = 0, end = 0;
        HashMap<String, Integer> map = new HashMap<>();
        
        while (start < gems.length) {
            if (map.size() == set.size()) {
                map.put(gems[start], map.get(gems[start]) - 1);
                if (map.get(gems[start]) == 0) map.remove(gems[start]);
                start++;
            }
            else if (end == gems.length) break;
            else {
                map.put(gems[end], map.getOrDefault(gems[end], 0) + 1);
                end++;
            }
            
            
            if (map.size() == set.size() && end - start < len) {
                answer[0] = start + 1;
                answer[1] = end;
                len = end - start;
            }
        }
        
        if (answer[0] == 0 && answer[1] == 0) {
            answer[0] = 1;
            answer[1] = gems.length;
        }
        
        return answer;
    }
}