package Level3;

import java.util.*;

//4202802를 참조한 나의 코드(성공)
class Solution4262803 {

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    PriorityQueue<Integer> maxpq = new PriorityQueue<Integer>(Collections.reverseOrder());

    public int[] solution(String[] operations) {

        int[] answer = new int[2];

        for(int i=0; i<operations.length; i++){
            String x = operations[i];

            StringTokenizer st = new StringTokenizer(x, " ");

            String operation = st.nextToken();
            int num = Integer.parseInt(st.nextToken());
            if(pq.size() < 1 && operation.equals("D")){
                continue;
            }

            if(operation.equals("I")){
                pq.offer(num);
                maxpq.offer(num);
                continue;
            }

            if(operation.equals("D")){
                if(num == -1){
                    int n = pq.poll();
                    maxpq.remove(n);
                } else {
                    int n = maxpq.poll();
                    pq.remove(n);
                }
            }
        }

        if(pq.size() >= 1){
            answer[0] = maxpq.poll();
            answer[1] = pq.poll();
        } else {
            answer[0] = 0;
            answer[1] = 0;
        }
        return answer;
    }
}
