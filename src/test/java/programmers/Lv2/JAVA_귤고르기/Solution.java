package programmers.Lv2.JAVA_귤고르기;

import java.util.Arrays;

class Solution {

    public Object solution(Object ... params) throws Exception {
        Object returnAnswer;

        try{
            // int k = Integer.parseInt(params[0].toString());
            returnAnswer = solution(params[0], params[1]);
            
            return returnAnswer;
        } catch(Exception e) {
            System.err.println("Common solution Error : " + e.getMessage());
            return null;
        }
        
    }

    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        //int tangerine_len = tangerine.length;
        
        int max_value = 0;
        for(int tan_val : tangerine){
            if(max_value < tan_val) max_value = tan_val;
        }
        
        int[] answer_arr = new int[max_value+1];
        
        
        //for(int i=0 ; i< answer_arr.length ; i++){
        //    answer_arr[i] = 0;
        //}
        
        
        for(int value : tangerine){
            answer_arr[value] = answer_arr[value] + 1;
        }
        
        Arrays.sort(answer_arr);
        
        int reverse_order = answer_arr.length;
        
        while(k > 0){
            reverse_order--;
            answer++;
            
            k = k - answer_arr[reverse_order];
        }
        
        
        return answer;
    }

}