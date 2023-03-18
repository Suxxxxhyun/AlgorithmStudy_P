package Level3;

import java.util.*;
class Solution72413 {

    int answer = 0;
    int[][] graph;
    //1번노드 ~ 200번 노드가 모두 100,000일때,
    //1번 노드 ~ 200번노드까지의 총 비용은, 100,000 * 200 = 20000000
    final int INF = 20000001;

    public int solution(int n, int s, int a, int b, int[][] fares) {

        graph = new int[n+1][n+1];

        for(int i=1; i<=n; i++){
            Arrays.fill(graph[i],INF);
        }

        for(int i=1; i<=n; i++){
            for(int j=1; j<=n; j++){
                if(i==j){
                    graph[i][j] = 0;
                }
            }
        }

        for(int i=0; i<fares.length; i++){
            int A = fares[i][0];
            int B = fares[i][1];
            int C = fares[i][2];
            graph[A][B] = C;
            graph[B][A] = C;
        }

        for(int k=1; k<=n; k++){
            for(int A=1; A<=n; A++){
                for(int B=1; B<=n; B++){
                    graph[A][B] = Math.min(graph[A][B], graph[A][k] + graph[k][B]);
                    //System.out.print(graph[A][B] + " ");
                }
                //System.out.println();
            }
        }

        int answer = graph[s][a] + graph[s][b];
        for(int i=1; i<=n; i++){
            answer = Math.min(answer, graph[s][i] + graph[i][a] + graph[i][b]);
        }
        return answer;
    }
}