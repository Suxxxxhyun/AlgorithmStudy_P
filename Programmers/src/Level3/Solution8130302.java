package Level3;

import java.util.*;
//https://moonsbeen.tistory.com/294 블로그참조
//삭제하고 난뒤, 행의 번호가 바뀌길래, ArrayList를 사용했는데,
//단순히 LinkedList의 성질을 활용해서 pre배열과 next배열을 생성하여, 삭제가 이루어지면 이전노드와 다음노드이 참조값을 바꾸어준다.
public class Solution8130302 {
    public String solution(int n, int k, String[] cmd) {
        int[] pre = new int[n];
        int[] next = new int[n];
        for(int i = 0; i < n; i++) {
            pre[i] = i - 1;
            next[i] = i + 1;
        }
        next[n - 1] = -1;

        Stack<Node> stack = new Stack<>();
        StringBuilder sb = new StringBuilder("O".repeat(n));
        for(int i = 0; i < cmd.length; i++) {
            char c = cmd[i].charAt(0);
            if(c == 'U') {
                int num = Integer.valueOf(cmd[i].substring(2));
                while(num-- > 0) {
                    k = pre[k];
                }
            } else if(c == 'D') {
                int num = Integer.valueOf(cmd[i].substring(2));
                while(num-- > 0) {
                    k = next[k];
                }
            } else if(c == 'C') {
                stack.push(new Node(pre[k], k, next[k]));
                if(pre[k] != -1) {
                    next[pre[k]] = next[k]; //현재 노드 삭제 후 앞뒤 연결
                }
                if(next[k] != -1) {
                    pre[next[k]] = pre[k];
                }
                sb.setCharAt(k, 'X');

                if(next[k] != -1) k = next[k];
                else k = pre[k]; //마지막 행인 경우에 바로 윗 행 선택
            } else {
                Node node = stack.pop();
                if(node.pre != -1) {
                    next[node.pre] = node.cur; //연결 정보 복구
                }
                if(node.nxt != -1) {
                    pre[node.nxt] = node.cur;
                }
                sb.setCharAt(node.cur, 'O');
            }
        }
        return sb.toString();
    }

    public class Node{
        int pre, cur, nxt;

        public Node(int pre, int cur, int nxt) {
            this.pre = pre;
            this.cur = cur;
            this.nxt = nxt;
        }
    }
}
