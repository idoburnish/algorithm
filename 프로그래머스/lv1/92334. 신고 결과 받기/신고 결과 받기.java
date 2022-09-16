import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) { 
        HashMap<String, HashSet<String>> map = new HashMap<>();
        HashMap<String, HashSet<String>> result = new HashMap<>();

        for (String str : report) {
            String[] list = str.split(" ");
            
            HashSet<String> temp = map.getOrDefault(list[1], new HashSet<>());
            temp.add(list[0]);
            map.put(list[1], temp);
            
            temp = result.getOrDefault(list[0], new HashSet<>());
            temp.add(list[1]);
            result.put(list[0], temp);
        }
        
        int[] answer = new int[id_list.length];
        for (int i=0; i<id_list.length; i++) {
            HashSet<String> list = result.getOrDefault(id_list[i], new HashSet<>());
            for (String name : list) {
                if (map.get(name).size() >= k) answer[i]++;
            }
        }
        
        return answer;
    }
}