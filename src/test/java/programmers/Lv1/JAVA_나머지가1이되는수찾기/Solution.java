package programmers.Lv1.JAVA_나머지가1이되는수찾기;

class Solution {
    
    public int solution(int n) {
        int answer = 0;
        //int count = 0;
        
        while(true) {
            answer++;
            if( n % answer == 1) break;  
        }
        
        return answer;
    }

}