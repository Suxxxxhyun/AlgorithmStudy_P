package Level1;

import java.util.*;

class Solution120866 {

    int answer = 0;
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1},{-1,-1},{1,1},{1,-1},{-1,1}};
    boolean[][] visited;
    class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] board) {

        visited = new boolean[board.length][board.length];
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                if(board[i][j] == 1 && !visited[i][j]){
                    bfs(i,j, board);
                }
            }
        }

        for(int i=0; i<board.length; i++){
            for(int j=0; j<board.length; j++){
                if(board[i][j] == 0){
                    answer++;
                }
                //System.out.print(board[i][j] + " ");
            }
            //System.out.println();
        }
        return answer;
    }

    public void bfs(int x, int y, int[][] board){
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(x,y));
        visited[x][y] = true;

        while(!q.isEmpty()){
            Node node = q.poll();
            int xx = node.x;
            int yy = node.y;
            for(int i=0; i<dir.length; i++){
                int nx = xx + dir[i][0];
                int ny = yy + dir[i][1];
                System.out.println("nx " + nx + "ny " + ny);

                if(nx < 0 || ny < 0 || nx >= board.length || ny >= board.length){
                    continue;
                }

                if(visited[nx][ny]){
                    continue;
                }

                if(!visited[nx][ny] && board[nx][ny] == 0){
                    board[nx][ny] = 1;
                    visited[nx][ny] = true;
                }
            }
        }

    }
}
