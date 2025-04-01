import java.util.List;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];

        for(int x = 0; x < commands.length; x++){
            List<Integer> list = new ArrayList<>();
            int i = commands[x][0]-1;
            int j = commands[x][1]-1;
            int k = commands[x][2]-1;
            for(int y = i; y <= j; y++){
                list.add(array[y]);
            }
            Collections.sort(list);
            answer[x] = list.get(k);
        }
        
        return answer;
    }
}