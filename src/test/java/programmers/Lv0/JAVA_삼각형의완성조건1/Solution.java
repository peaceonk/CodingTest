package programmers.Lv0.JAVA_삼각형의완성조건1;

import java.util.Arrays;

class Solution {

    public int solution(int[] sides) {
        int answer = 0;
        
        Arrays.sort(sides);
        
        //System.out.println(Arrays.toString(sides));
        
        if(sides[0] + sides[1] > sides[2]) answer = 1;
        else answer = 2;
        
        return answer;
    }
    
}