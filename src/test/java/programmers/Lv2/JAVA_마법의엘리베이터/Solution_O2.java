package programmers.Lv2.JAVA_마법의엘리베이터;

class Solution_O2 {
    public int solution(int storey) {

        if (storey == 0)
            return 0;

        if (storey % 10 == 0)
            return solution(storey / 10);

        if (storey < 10)
            return Math.min(storey, 11 - storey);

        int mod = storey % 10;

        int wayUp = 10 - mod + solution(storey + 10 - mod);
        int wayDown = mod + solution(storey - mod);

        return Math.min(wayUp, wayDown);
    }
}
