package programmers.Lv0.JAVA_배열원소의길이;

import java.util.Set;
import java.util.LinkedHashSet;

class Solution {
    
    public String solution(String my_string) {
        String answer = "";
        
        char[] arr_my_char = my_string.toCharArray();
        
        Set<Character> set_my_char = new LinkedHashSet<>();
        
        for(char c : arr_my_char){
            set_my_char.add(c);
        }
        //System.out.println(set_my_char.toString());
        
        for(char c : set_my_char){
            answer += Character.toString(c);
        }
        //System.out.println(answer);
        
        return answer;
    }
    
}