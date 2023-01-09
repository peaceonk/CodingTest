package programmers.Lv1.JAVA_크기가작은부분문자열;

class Solution {
    
    public int solution(String t, String p) {
        int answer = 0;
        
        int length_t = t.length();
        
        Long int_p = Long.parseLong(p);
        int length_p = p.length();
        
        for(int i=0 ; i<= length_t-length_p ; i++){
            String subStr_t = t.substring(i,i+length_p);
            Long int_subStr_t = Long.parseLong(subStr_t);
            
            //System.out.println(int_p +" : "+ int_subStr_t);
            
            if(int_p >= int_subStr_t) answer++;
        }
        
        
        return answer;
    }

}