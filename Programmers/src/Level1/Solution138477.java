package Level1;

import java.util.*;

class Solution138477 {

    PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
    ArrayList<Integer> answer = new ArrayList<Integer>();

    public ArrayList<Integer> solution(int k, int[] score) {

        for(int i=0; i<score.length; i++){
            if(pq.size() == k){
                if(pq.peek() > score[i]){
                    answer.add(pq.peek());
                    continue;
                }
                pq.poll();
            }
            if(pq.size() < k){
                /*if(!pq.isEmpty()){
                    if(pq.peek() > score[i]){
                        break;
                    }
                }*/
                System.out.print(score[i] + " ");
                pq.offer(score[i]);
                //20, 40, 300, 300
            }
            answer.add(pq.peek());
        }
        return answer;
    }
}
