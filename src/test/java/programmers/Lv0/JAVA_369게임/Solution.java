package programmers.Lv0.JAVA_369게임;

class Solution {

    public int solution(int order) {
        int answer = 0;
        
        String str_order = Integer.toString(order);
        
        for(char c : str_order.toCharArray() ){
            if( c == '3' || c == '6' || c == '9') answer++;
        }
        
        return answer;
    }
    
}