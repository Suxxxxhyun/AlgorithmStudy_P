package Level3;

//https://velog.io/@lifeisbeautiful/Java-%ED%94%84%EB%A1%9C%EA%B7%B8%EB%9E%98%EB%A8%B8%EC%8A%A4-DFSBFS-%EB%84%A4%ED%8A%B8%EC%9B%8C%ED%81%AC 블로그 참조
class Solution4316202 {
    static boolean visit[];

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visit = new boolean[n];


        for(int i=0; i<n; i++) {
            if(!visit[i]) {
                DFS(i, computers, n);
                answer++;
            }
        }

        return answer;
    } // End of main

    static void DFS(int i, int [][] computers, int n) {
        visit[i] = true;

        for(int j=0; j<n; j++) {
            if(!visit[j] && computers[i][j] == 1) {
                DFS(j, computers, n);
            }
        }

    } // End of DFS
} // End of class
