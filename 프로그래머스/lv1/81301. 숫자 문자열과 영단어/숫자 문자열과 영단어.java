import java.util.*;

class Solution {
    public int solution(String s) {
        String answer = "";
        
        int idx = 0;
        while (idx < s.length()) {
            if (Character.isDigit(s.charAt(idx))) {
                answer += s.charAt(idx);
                idx++;
            }
            else {
                String str = "";
                while (checkNum(str) == -1) {
                    str += s.charAt(idx);
                    idx++;
                }
                
                answer += checkNum(str);
            }   
        }
        
        return Integer.parseInt(answer);
    }
    
    public int checkNum(String str) {
        int num = -1;
        
        switch (str) {
            case "zero":
                num = 0;
                break;
            case "one":
                num = 1;
                break;
            case "two":
                num = 2;
                break;
            case "three":
                num = 3;
                break;
            case "four":
                num = 4;
                break;
            case "five":
                num = 5;
                break;
            case "six":
                num = 6;
                break;
            case "seven":
                num = 7;
                break;
            case "eight":
                num = 8;
                break;
            case "nine":
                num = 9;
                break;
        }
        
        return num;
    }
}