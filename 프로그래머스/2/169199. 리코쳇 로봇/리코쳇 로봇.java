import java.util.*;

class Solution {
    public int solution(String[] board) {
        int[] dx = {-1,1,0,0};
        int[] dy = {0,0,-1,1};    
        int n = board.length;
        int m = board[0].length();
        boolean[][] visit = new boolean[n][m];
        Queue<Point> q = new LinkedList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j < m; j++){
                if(board[i].charAt(j) == 'R'){
                    q.add(new Point(i, j, 0));
                    visit[i][j] = false;
                    break;
                }
            }
        }

        int answer = -1;
        while(!q.isEmpty()){
            Point cur = q.poll();
            if(board[cur.x].charAt(cur.y) == 'G'){
                return cur.count;
            }
            for(int i = 0; i < 4; i++){
                int nextX = cur.x + dx[i];
                int nextY = cur.y + dy[i];
                while(true){
                    if(0 <= nextX && nextX < n && 0 <= nextY && nextY < m && board[nextX].charAt(nextY) != 'D'){
                        nextX += dx[i];
                        nextY += dy[i];
                    }else{
                        nextX -= dx[i];
                        nextY -= dy[i];
                        break;
                    }
                } 
                if(!visit[nextX][nextY]){
                    q.add(new Point(nextX,nextY,cur.count+1));
                    visit[nextX][nextY] = true;
                }
            }


        }



        return answer;
    }
}
class Point {
    int x;
    int y;
    int count;
    
    public Point(int x, int y, int count){
        this.x = x;
        this.y = y;
        this.count = count;
    }
}