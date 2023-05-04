package Level2;

import java.util.*;
//https://ksb-dev.tistory.com/291

public class Solution16919902 {

    private final int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    private final char ROBOT = 'R', DISABLE = 'D', GOAL = 'G';
    private int n,m;

    private class Moving{
        int x, y, depth;

        public Moving(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }
    public int solution(String[] board) {
        int answer = 0;

        n = board.length;
        m = board[0].length();

        Moving robot = null;
        Moving goal = null;

        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                char ch = board[i].charAt(j);

                if(ch == ROBOT){
                    robot = new Moving(i,j,0);
                } else if(ch == GOAL){
                    goal = new Moving(i,j,0);
                }
            }
        }

        answer = bfs(board, robot, goal);
        return answer;
    }

    private int bfs(String[] board, Moving robot, Moving goal){
        Queue<Moving> q = new LinkedList<>();
        q.add(robot);
        boolean[][] visited= new boolean[n][m];
        visited[robot.x][robot.y] = true;

        while(!q.isEmpty()){
            Moving cn = q.poll();

            if(cn.x == goal.x && cn.y == goal.y){
                return cn.depth;
            }

            for(int i=0; i<4; i++){
                int nx = cn.x;
                int ny = cn.y;

                while(inRange(nx,ny) && board[nx].charAt(ny) != DISABLE){
                    nx += dir[i][0];
                    ny += dir[i][1];
                }

                nx -= dir[i][0];
                ny -= dir[i][1];

                //두번째 조건은 뭐지?
                if(visited[nx][ny] || (cn.x == nx && cn.y == ny)){
                    continue;
                }

                visited[nx][ny] = true;
                q.offer(new Moving(nx,ny,cn.depth + 1));
            }
        }
        return -1;
    }

    private boolean inRange(int x, int y){
        return x >= 0 && y >= 0 && x < n && y < m;
    }

}
