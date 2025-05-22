class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int count = 0;
        int zero = 0;
        for(int i : lottos){
            if(i == 0){
                zero++;
                continue;
            }
            for(int j : win_nums){
                if(i == j){
                    count++;
                    break;
                }
            }

        }

        return new int[]{rank(count + zero), rank(count)};
    }

    private int rank(int count){
        switch(count){
            case 6:
                return 1;
            case 5:
                return 2;
            case 4:
                return 3;
            case 3:
                return 4;
            case 2:
                return 5;
            default:
                return 6;
        }
    }
}