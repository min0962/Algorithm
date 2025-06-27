import java.util.*;
class Solution {
    public int solution(int[][] jobs) {
        int answer = 0;
        Arrays.sort(jobs, (n1, n2) -> n1[0] - n2[0]);
        PriorityQueue<int[]> pq = new PriorityQueue<>((n1,n2) -> n1[1] - n2[1]);

        int time = 0;
        int totalTime = 0;
        int idx = 0;
        int count = 0;

        while(count < jobs.length){

            while(idx < jobs.length && jobs[idx][0] <= time){
                pq.offer(jobs[idx++]);
            }
            if(pq.isEmpty()){
                time = jobs[idx][0];
            } else {
                int job[] = pq.poll();
                time += job[1];
                totalTime += time - job[0];
                count++;
            }

        }

        return totalTime / jobs.length;
    }
}