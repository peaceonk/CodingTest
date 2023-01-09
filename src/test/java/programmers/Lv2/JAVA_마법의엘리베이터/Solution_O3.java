package programmers.Lv2.JAVA_마법의엘리베이터;

class Solution_O3 {

    int answer = Integer.MAX_VALUE;
    int maxStep;
    public int solution(int storey) {
        DFS(1, String.valueOf(storey), 0);
        return answer;
    }

    public void DFS(int step, String storey, int count) {
        if(step == storey.length()) {
            int head = Integer.parseInt(storey.substring(0,1));
            answer = head>=6?(int)Math.min(count+10-head+1,answer):(int)Math.min(count+head, answer);
        }else{
            int tempStorey = Integer.parseInt(storey);
            int last= Integer.parseInt(storey.substring(storey.length()-step,storey.length()-step+1));
            DFS(step+1, String.valueOf((int)(tempStorey + (10-last)*Math.pow(10,step-1))), count + 10-last);
            DFS(step+1, String.valueOf((int)(tempStorey - last*Math.pow(10,step-1))), count + last);
        }
    }
}