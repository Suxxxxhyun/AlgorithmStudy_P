package Level2;

import java.util.*;
//내 접근 방식
/*
1. list에 wires배열을 1번부터 n번까지 인접리스트로 표현한다.
2. 끊을 전력망을 택한다음, 그 전력망을 실제로 끊어준다.(이를 위해 list에서 remove메소드사용)
3. 실제로 끊은뒤, dfs로 탐색하여 전력망의 개수를 세어준다.
4. 개수를 세어준뒤, ans에 담아준다.
5. result배열에 둘의 차이(ans의 0번째와 1번째)를 담아준다.
6. result배열을 정렬시켜주어서 둘의 차이가 가장 적은것을 answer에 담아준다.
 */
class Solution86971 {

    int answer = -1;
    int cnt = 0;
    ArrayList<Integer>[] list;
    ArrayList<Integer> ans = new ArrayList<Integer>();
    ArrayList<Nums> result = new ArrayList<Nums>();
    boolean[] visited;
    class Nums implements Comparable<Nums>{
        //차이를 담는 변수(minus)
        int minus;

        public Nums(int minus){
            this.minus = minus;
        }

        public int compareTo(Nums other){
            return this.minus - other.minus;
        }

        public String toString(){
            return "minus = " + minus;
        }
    }

    public int solution(int n, int[][] wires) {

        list = new ArrayList[n + 1];
        visited = new boolean[n + 1];
        for(int i=0; i<list.length; i++){
            list[i] = new ArrayList<Integer>();
        }

        //인접리스트로 표현
        for(int i=0; i<wires.length; i++){
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }

        //방문처리도 다시 해야함. //리스트의 원소 삭제하기방법 - Integer.valueOf사용
        for(int i=0; i<wires.length; i++){
            list[wires[i][0]].remove(Integer.valueOf(wires[i][1]));
            list[wires[i][1]].remove(Integer.valueOf(wires[i][0]));

            for(int j=1; j<=n; j++){
                if(!visited[j]){
                    int val = dfs(wires, j);
                    ans.add(val);
                    cnt = 0;
                }
            }
            //System.out.println(ans);
            result.add(new Nums(Math.abs(ans.get(0) - ans.get(1))));
            ans = new ArrayList<Integer>();
            cnt = 0;
            visited = new boolean[n + 1];
            list[wires[i][0]].add(wires[i][1]);
            list[wires[i][1]].add(wires[i][0]);
        }

        Collections.sort(result);
        //System.out.println(result);
        answer = result.get(0).minus;
        return answer;
    }

    int dfs(int[][] wires, int start){
        visited[start] = true;
        System.out.print(start + " ");
        cnt += 1;
        for(int i=0; i<list[start].size(); i++){
            if(!visited[list[start].get(i)]){
                dfs(wires, list[start].get(i));
            }
        }
        return cnt;
    }

}
