import java.util.*;

class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int answer = 0;

        long total = 0;
        long q1sum = 0;

        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        for(int i = 0; i < queue1.length; i++){
            q1.add(queue1[i]);
            q2.add(queue2[i]);
            total += queue1[i] + queue2[i];
            q1sum += queue1[i];
        }
        if(total % 2 != 0) {
            return -1;
        }

        int cnt = 0;
        long mid = total / 2;
        while(true){
            if(cnt > (queue1.length + queue2.length) * 2){
                return -1;
            }
            if(mid == q1sum) {
                return cnt;
            } else {
                if(q1sum > mid) {
                    q1sum -= q1.peek();
                    q2.add(q1.poll());
                } else {
                    q1sum += q2.peek();
                    q1.add(q2.poll());
                }
                cnt++;
            }
        }
    }
}