package Level2;

//1:57 ~ 2:20
import java.util.*;

class Solution15999303 {

    int answer = 0;
    char[][] map;
    boolean[][] visited;
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};
    class Node{
        int x,y,depth;

        public Node(int x, int y, int depth){
            this.x = x;
            this.y = y;
            this.depth = depth;
        }
    }

    public int solution(String[] maps) {

        Node start = null;
        Node level = null;
        Node exit = null;

        map = new char[maps.length][maps[0].length()];
        visited = new boolean[maps.length][maps[0].length()];
        for(int i=0; i<maps.length; i++){
            for(int j=0; j<maps[i].length(); j++){
                map[i][j] = maps[i].charAt(j);
                if(map[i][j] == 'S'){
                    start = new Node(i,j,0);
                } else if(map[i][j] == 'L'){
                    level = new Node(i,j,0);
                } else if(map[i][j] == 'E'){
                    exit = new Node(i,j,0);
                }
            }
        }

        answer = bfs(start.x, start.y, level.x, level.y);
        System.out.println(answer);
        if(answer > -1){
            visited = new boolean[maps.length][maps[0].length()];
            int temp = bfs(level.x, level.y, exit.x, exit.y);
            System.out.println(temp);
            if(temp == -1){
                answer = -1;
            } else {
                answer += temp;
            }
        }
        return answer;
    }

    int bfs(int startX, int startY, int endX, int endY){
        Queue<Node> q = new LinkedList<Node>();
        q.offer(new Node(startX, startY, 0));
        visited[startX][startY] = true;
        int val = -1;
        while(!q.isEmpty()){
            Node n = q.poll();

            /*if(n.x == endX && n.y == endY){
                val = n.depth;
            }*/

            for(int i=0; i<4; i++){
                int nx = n.x + dir[i][0];
                int ny = n.y + dir[i][1];

                if(nx < 0 || ny < 0 || nx >= map.length || ny >= map[0].length){
                    continue;
                }

                if(map[nx][ny] == 'X'){
                    continue;
                }

                if(nx == endX && ny == endY){
                    val = n.depth + 1;
                    return val;
                }

                if(!visited[nx][ny] && map[nx][ny] != 'X'){
                    visited[nx][ny] = true;
                    q.offer(new Node(nx, ny, n.depth+1));
                }
            }
        }
        return val;

    }
}
