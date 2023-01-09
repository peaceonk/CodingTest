package programmers.Lv0.JAVA_중복된문자제거;

class Solution {
    
    public int[] solution(String[] strlist) {
        int[] answer = new int[strlist.length];
        int answer_index = 0;
        
        for(String str : strlist){
            answer[answer_index] = str.length();
            answer_index++;
        }
        
        return answer;
    }
    
}