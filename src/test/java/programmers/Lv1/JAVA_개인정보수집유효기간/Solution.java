package programmers.Lv1.JAVA_개인정보수집유효기간;

import java.util.List;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import java.text.SimpleDateFormat;

class Solution {
    public int[] solution(String today, String[] terms, String[] privacies) {
        int[] answer = {};
        List<Integer> list_answer = new ArrayList<Integer>();
        
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd");
        Date today_today = null;
        
        try {
            today_today = df.parse(today);
        } catch (Exception e) {
            e.printStackTrace();
        }            
        
        for(int i=0 ; i<privacies.length ; i++){            
            String[] arr_privacy = privacies[i].split(" ");

            Date privacy_date = null;
            String privacy_clause = "";
                
            try {
                privacy_date = df.parse(arr_privacy[0]);
                privacy_clause = arr_privacy[1];
            } catch (Exception e) {
                e.printStackTrace();
            }
            
            cal.setTime(privacy_date);
            
            // System.out.println(privacy_clause + "\t " + privacy_date);
            
            Date expired = null;
            String[] exp_term = null;
            
            for(String term : terms){
                String[] arr_term = term.split(" ");
                
                String term_clause = arr_term[0];
                int term_month = Integer.parseInt(arr_term[1]);
                
                //System.out.println(term_clause + "\t" + term_month);
                
                if(privacy_clause.equals(term_clause)) {
                    cal.add(Calendar.MONTH, term_month);
                    exp_term = arr_term;
                }
            }
            
            expired = cal.getTime();
            
            if(today_today.compareTo(expired) >= 0){

                int index = i+1;
                list_answer.add(index);
                
                //System.out.println(index + "\t" + df.format(today_today) + "\t" + df.format(expired) + "\t" + df.format(privacy_date) + "\t" + Arrays.toString(exp_term));
            }
            
        }
        
        answer = list_answer.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        
        //System.out.println(Arrays.toString(answer));
        
        return answer;
    }
}