package Level2;

import java.util.*;

class Solution1844 {

    int answer = 0;
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    class Node{
        int x, y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
        }
    }

    public int solution(int[][] maps) {

        boolean [][] visited = new boolean[maps.length][maps[0].length];
        bfs(maps,visited);
        return answer;
    }

    public void bfs(int[][] maps, boolean[][] visited){

        int n = maps.length;
        int m = maps[0].length;

        Queue<Node> q = new LinkedList<Node>();

        visited[0][0] = true;
        q.offer(new Node(0,0));

        while(!q.isEmpty()){
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for(int k=0; k<4; k++){
                int nx = x + dir[k][0];
                int ny = y + dir[k][1];

                if(nx < 0 || ny < 0 || nx >= n || ny >= m){
                    continue;
                }

                if(maps[nx][ny] == 0){
                    continue;
                }

                if(!visited[nx][ny] && maps[nx][ny] == 1){
                    visited[nx][ny] = true;
                    maps[nx][ny] = maps[x][y] + 1;
                    q.offer(new Node(nx,ny));
                }
            }
        }

        answer = maps[n-1][m-1];
        if(answer == 1){
            answer = -1;
        }
    }
}
