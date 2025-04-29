import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;

        Arrays.sort(targets, (n1, n2) -> n1[1] - n2[1]);

        int end = targets[0][1];
        answer++;
        for(int[] t : targets){
            if(t[0] >= end){
                end = t[1];
                answer++;
            }
        }

        return answer;
    }
}
