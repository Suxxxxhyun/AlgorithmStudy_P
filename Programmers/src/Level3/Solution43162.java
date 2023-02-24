package Level3;

//틀린코드 -> visited를 2차원배열로 하여, 주어진 computers의 2차원배열의 좌표를 방문했으면 true, 방문하지 않으면 false로 반환하게 했는데,
//Solution43162Test반례 사례와 같이, 인접행렬상에서 그래프덩어리로 개수를 센다고 하였을때, (2,2)는 이미 처리되었는데 또 처리되는 상황
//따라서, 2차원배열로 하는 graph를 상하좌우로 방문하게 하면 논리적으로 모순이 발생함.
//그래서 Solution4316202처럼 해줘야한다.
class Solution43162 {

    int answer = 0;
    boolean[][] visited;
    boolean[] computer;
    int[][] dir = {{-1,0},{1,0},{0,-1},{0,1}};

    public int solution(int n, int[][] computers) {

        visited = new boolean[n][n];
        computer = new boolean[n];
        int cnt = 0;

        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(!visited[i][j] && computers[i][j] == 1 && !computer[j]){
                    dfs(i,j,computers,n);
                    cnt += 1;
                };
            }
        }

        answer = cnt;

        return answer;
    }

    public void dfs(int x, int y, int[][] computers, int n){
        visited[x][y] = true;

        for(int i=0; i<4; i++){
            int nx = x + dir[i][0];
            int ny = y + dir[i][1];

            if(nx < 0 || ny < 0 || nx >= n || ny >= n){
                continue;
            }

            if(visited[nx][ny]){
                continue;
            }

            if(computers[nx][ny] == 0){
                continue;
            }

            if(!visited[nx][ny] && computers[nx][ny] == 1){
                dfs(nx, ny, computers, n);
            }
        }
    }
}
