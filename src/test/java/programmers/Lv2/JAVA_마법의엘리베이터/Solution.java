package programmers.Lv2.JAVA_마법의엘리베이터;

import java.lang.Math;

class Solution {
    
    /**
     * 
     * @param storey : 현재 층
     * @return : 0층 까지 도달하기 위한 이동 수
     */
    public int solution(int storey) throws Exception {
        int answer = 0;
        
        int tmp_storey = storey;
        int i = 0;
        int zero = 0;
        
        while(storey > 0) {
            zero = (int)Math.pow(10, i);
            tmp_storey = storey * zero;
            
            System.out.print(tmp_storey);
            
            int per_storey = storey % 10;
            int opp_per_storey = 10 - per_storey;
            int per_storey10 = (storey % 100) / 10;
            
            System.out.print("[" + per_storey10 + "]");
            if(per_storey == opp_per_storey && per_storey10 > 4){
                System.out.print(" + " + opp_per_storey*zero + "(" + opp_per_storey + ")");
                
                storey += opp_per_storey;
                answer += opp_per_storey;
            }else if(per_storey <= opp_per_storey) {
                System.out.print(" - " + per_storey*zero + "(" + per_storey + ")");
                
                storey -= per_storey;
                answer += per_storey;
            }else{
                System.out.print(" + " + opp_per_storey*zero + "(" + opp_per_storey + ")");
                
                storey += opp_per_storey;
                answer += opp_per_storey;
            }
            System.out.println(" = " +  storey * zero + "(" + answer + ")");
            
            storey /= 10;
            i++;
        }
        
        return answer;
    }
}