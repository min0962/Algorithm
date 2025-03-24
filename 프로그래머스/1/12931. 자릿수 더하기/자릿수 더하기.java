import java.util.*;

public class Solution {
    public int solution(int n) {
        int answer = 0;
        while(n > 0){
            int s = n%10;
            n = n/10;
            answer += s;
        }
        
        return answer;
    }
}